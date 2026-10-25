
package com.devpath.devpath;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LearningProgressController {

    private final LearningProgressRepository repository;

    private static final Map<String, String> LESSONS = Map.of(
            "java-basics", "Java Basics",
            "python-basics", "Python Basics",
            "web-basics", "HTML, CSS and JavaScript"
    );

    public LearningProgressController(
            LearningProgressRepository repository) {
        this.repository = repository;
    }

    @GetMapping(
            value = "/progress",
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String progress(
            @RequestParam(defaultValue = "Learner") String learner) {

        String name = learner.trim();

        if (!name.matches("[A-Za-z0-9 _.-]{1,50}")) {
            name = "Learner";
        }

        List<LearningProgress> records =
                repository.findByLearnerNameIgnoreCaseOrderByLessonIdAsc(name);

        Map<String, Boolean> completed = new java.util.HashMap<>();

        for (LearningProgress record : records) {
            completed.put(record.getLessonId(), record.isCompleted());
        }

        long completedCount = LESSONS.keySet().stream()
                .filter(id -> Boolean.TRUE.equals(completed.get(id)))
                .count();

        StringBuilder html = new StringBuilder();

        html.append("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <title>DevPath Learning Progress</title>
                <style>
                body { font-family: Arial, sans-serif; background:#f3f6fb;
                       margin:0; padding:30px; color:#172033; }
                main { max-width:750px; margin:auto; background:white;
                       padding:28px; border-radius:14px; }
                .lesson { border:1px solid #dce3ee; padding:16px;
                          margin:12px 0; border-radius:10px; }
                button { background:#2357d5; color:white; border:0;
                         padding:10px 15px; border-radius:7px; cursor:pointer; }
                input { padding:10px; border:1px solid #bbb;
                        border-radius:7px; }
                a { color:#2357d5; }
                </style>
                </head>
                <body><main>
                <h1>DevPath Learning Progress</h1>
                <p>Track your completed lessons.</p>
                <form method="get" action="/progress">
                <label for="learner">Learner name:</label>
                <input id="learner" name="learner" maxlength="50" required>
                <button type="submit">Load Progress</button>
                </form>
                <h2>Progress for: 
                """).append(escapeHtml(name)).append("</h2>");

        html.append("<p>Completed: ")
                .append(completedCount)
                .append(" / ").append(LESSONS.size())
                .append(" lessons</p>");

        for (Map.Entry<String, String> lesson : LESSONS.entrySet()) {
            String id = lesson.getKey();
            boolean done = Boolean.TRUE.equals(completed.get(id));

            html.append("<section class=\"lesson\"><h3>")
                    .append(escapeHtml(lesson.getValue()))
                    .append("</h3><p>Status: ")
                    .append(done ? "Completed" : "Not completed")
                    .append("</p><form method=\"post\" action=\"/progress/complete\">")
                    .append("<input type=\"hidden\" name=\"learner\" value=\"")
                    .append(escapeHtml(name))
                    .append("\"><input type=\"hidden\" name=\"lessonId\" value=\"")
                    .append(id)
                    .append("\"><input type=\"hidden\" name=\"completed\" value=\"")
                    .append(!done)
                    .append("\"><button type=\"submit\">")
                    .append(done ? "Mark incomplete" : "Mark completed")
                    .append("</button></form></section>");
        }

        html.append("""
                <p><a href="/">Back to DevPath Home</a></p>
                </main></body></html>
                """);

        return html.toString();
    }

    @PostMapping("/progress/complete")
    public String complete(
            @RequestParam String learner,
            @RequestParam String lessonId,
            @RequestParam boolean completed,
            RedirectAttributes redirectAttributes) {

        String name = learner.trim();

        if (!name.matches("[A-Za-z0-9 _.-]{1,50}")
                || !LESSONS.containsKey(lessonId)) {
            redirectAttributes.addAttribute("learner", "Learner");
            return "redirect:/progress";
        }

        Optional<LearningProgress> existing =
                repository.findByLearnerNameIgnoreCaseAndLessonIdIgnoreCase(
                        name, lessonId);

        LearningProgress record = existing.orElseGet(
                () -> new LearningProgress(name, lessonId, completed));

        record.setCompleted(completed);
        repository.save(record);

        redirectAttributes.addAttribute("learner", name);
        return "redirect:/progress";
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
