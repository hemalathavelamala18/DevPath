
package com.devpath.devpath;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private String page(String title, String content) {
        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>{{TITLE}} | DevPath</title>
                    <style>
                        * { box-sizing: border-box; }
                        body {
                            margin: 0;
                            font-family: Arial, sans-serif;
                            background: #f4f7fb;
                            color: #253047;
                            line-height: 1.6;
                        }
                        header {
                            background: #172554;
                            color: white;
                            padding: 18px 7%;
                            display: flex;
                            justify-content: space-between;
                            align-items: center;
                            flex-wrap: wrap;
                            gap: 12px;
                        }
                        header a {
                            color: white;
                            text-decoration: none;
                            margin-right: 14px;
                        }
                        header .brand {
                            font-size: 24px;
                            font-weight: bold;
                        }
                        nav { display: flex; flex-wrap: wrap; gap: 8px; }
                        main {
                            max-width: 1100px;
                            margin: 30px auto;
                            padding: 0 20px;
                            min-height: 65vh;
                        }
                        .hero {
                            background: #dbeafe;
                            padding: 40px 24px;
                            border-radius: 14px;
                            margin-bottom: 30px;
                        }
                        h1 { color: #172554; }
                        .cards {
                            display: grid;
                            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
                            gap: 18px;
                            margin: 20px 0 30px;
                        }
                        .card {
                            background: white;
                            padding: 22px;
                            border-radius: 12px;
                            box-shadow: 0 2px 8px rgba(0,0,0,0.07);
                            margin: 16px 0;
                        }
                        .card h3 { margin-top: 0; }
                        a { color: #1d4ed8; }
                        .btn, button {
                            display: inline-block;
                            background: #1d4ed8;
                            color: white;
                            text-decoration: none;
                            padding: 10px 16px;
                            border: none;
                            border-radius: 7px;
                            cursor: pointer;
                            margin: 5px 5px 5px 0;
                            font-size: 15px;
                        }
                        .secondary { background: #0f766e; }
                        input {
                            padding: 10px;
                            margin: 5px;
                            max-width: 100%;
                            border: 1px solid #cbd5e1;
                            border-radius: 6px;
                        }
                        footer {
                            text-align: center;
                            padding: 20px;
                            background: #e2e8f0;
                            color: #475569;
                        }
                        @media (max-width: 600px) {
                            header { padding: 16px; }
                            main { padding: 0 14px; }
                            .hero { padding: 25px 18px; }
                        }
                    </style>
                </head>
                <body>
                    <header>
                        <a class="brand" href="/">DevPath</a>
                        <nav>
                            <a href="/">Home</a>
                            <a href="/courses">Courses</a>
                            <a href="/practice">Practice</a>
                            <a href="/placements">Placements</a>
                            <a href="/roadmap">Roadmap</a>
                            <a href="/login">Login</a>
                            <a href="/register">Register</a>
                        </nav>
                    </header>
                    <main>
                        {{CONTENT}}
                    </main>
                    <footer>
                        DevPath - Learn coding. Build projects. Prepare for placements.
                    </footer>
                </body>
                </html>
                """;

        return template
                .replace("{{TITLE}}", title)
                .replace("{{CONTENT}}", content);
    }

    @GetMapping("/")
    public String home() {
        return page("Home", """
                <section class="hero">
                    <h1>Welcome to DevPath!</h1>
                    <p>Your programming learning and placement preparation portal.</p>
                    <p>Learn coding. Build projects. Prepare for placements.</p>
                    <a class="btn" href="/courses">Explore Courses</a>
                    <a class="btn secondary" href="/practice">Start Practicing</a>
                </section>
                <h2>Start Your Learning Journey</h2>
                <div class="cards">
                    <div class="card">
                        <h3>Programming Courses</h3>
                        <p>Learn Java, Python, and web development.</p>
                        <a href="/courses">View Courses</a>
                    </div>
                    <div class="card">
                        <h3>Practice Problems</h3>
                        <p>Improve your programming and problem-solving skills.</p>
                        <a href="/practice">Practice Now</a>
                    </div>
                    <div class="card">
                        <h3>Placement Preparation</h3>
                        <p>Prepare for interviews, aptitude tests, and placements.</p>
                        <a href="/placements">Get Prepared</a>
                    </div>
                </div>
                """);
    }

    @GetMapping("/courses")
    public String courses() {
        return page("Courses", """
                <h1>Programming Courses</h1>
                <div class="cards">
                    <div class="card">
                        <h3>Java Programming</h3>
                        <p>Learn Java fundamentals, object-oriented programming,
                        and coding concepts.</p>
                        <a class="btn" href="/courses/java">Learn Java</a>
                    </div>
                    <div class="card">
                        <h3>Python Programming</h3>
                        <p>Learn Python syntax, data structures, and problem-solving.</p>
                        <a class="btn" href="/courses/python">Learn Python</a>
                    </div>
                    <div class="card">
                        <h3>Web Development</h3>
                        <p>Explore HTML, CSS, JavaScript, and web fundamentals.</p>
                        <a class="btn" href="/courses/web">Learn Web Development</a>
                    </div>
                </div>
                """);
    }

    @GetMapping("/courses/java")
    public String javaCourse() {
        return page("Java Programming", """
                <h1>Java Programming</h1>
                <div class="card">
                    <h3>Topics to Learn</h3>
                    <ul>
                        <li>Java syntax and variables</li>
                        <li>Data types and operators</li>
                        <li>Conditional statements and loops</li>
                        <li>Classes and objects</li>
                        <li>Inheritance and polymorphism</li>
                        <li>Collections and exception handling</li>
                    </ul>
                </div>
                <a class="btn" href="/practice">Practice Coding</a>
                <a href="/courses">Back to Courses</a>
                """);
    }

    @GetMapping("/courses/python")
    public String pythonCourse() {
        return page("Python Programming", """
                <h1>Python Programming</h1>
                <div class="card">
                    <h3>Topics to Learn</h3>
                    <ul>
                        <li>Python syntax and variables</li>
                        <li>Data types and operators</li>
                        <li>Conditions and loops</li>
                        <li>Lists, tuples, and dictionaries</li>
                        <li>Functions and modules</li>
                        <li>Object-oriented programming</li>
                    </ul>
                </div>
                <a class="btn" href="/practice">Practice Coding</a>
                <a href="/courses">Back to Courses</a>
                """);
    }

    @GetMapping("/courses/web")
    public String webCourse() {
        return page("Web Development", """
                <h1>Web Development</h1>
                <div class="card">
                    <h3>Topics to Learn</h3>
                    <ul>
                        <li>HTML page structure</li>
                        <li>CSS styling and responsive design</li>
                        <li>JavaScript fundamentals</li>
                        <li>Forms and user interaction</li>
                        <li>Client-server concepts</li>
                        <li>Web application development</li>
                    </ul>
                </div>
                <a class="btn" href="/practice">Practice Coding</a>
                <a href="/courses">Back to Courses</a>
                """);
    }

    @GetMapping("/practice")
    public String practice() {
        return page("Practice", """
                <h1>Programming Practice</h1>

                <div class="card">
                    <h3>Question 1: Even or Odd</h3>
                    <p>For this practice test, enter 5 as the expected answer.</p>
                    <p>Example: 2, 4, 6 are even numbers.</p>
                    <form action="/practice/check" method="get">
                        <label for="answer">Your answer:</label>
                        <input id="answer" name="answer" type="number" required>
                        <button type="submit">Check Answer</button>
                    </form>
                </div>

                <div class="card">
                    <h3>Question 2: Sum of Numbers</h3>
                    <p>Calculate the sum of all numbers from 1 to N.</p>
                    <form action="/practice/check-loop" method="get">
                        <label for="n">Enter N:</label>
                        <input id="n" name="n" type="number" min="1"
                               max="10000" required>
                        <button type="submit">Calculate Sum</button>
                    </form>
                </div>
                """);
    }

    @GetMapping("/practice/check")
    public String checkAnswer(
            @RequestParam(name = "answer", defaultValue = "") String answer) {

        if ("5".equals(answer.trim())) {
            return page("Practice Result", """
                    <h1>Practice Result</h1>
                    <p>Correct! Your answer is correct.</p>
                    <a class="btn" href="/practice">Try Again</a>
                    """);
        }

        return page("Practice Result", """
                <h1>Practice Result</h1>
                <p>Not quite. Please try again.</p>
                <a class="btn" href="/practice">Try Again</a>
                """);
    }

    @GetMapping("/practice/check-loop")
    public String checkLoop(
            @RequestParam(name = "n", defaultValue = "1") int n) {

        if (n < 1 || n > 10000) {
            return page("Practice Result", """
                    <h1>Invalid Input</h1>
                    <p>Please enter a number between 1 and 10000.</p>
                    <a class="btn" href="/practice">Try Again</a>
                    """);
        }

        long sum = (long) n * (n + 1) / 2;

        return page("Practice Result", """
                <h1>Sum Result</h1>
                <p>The sum of numbers from 1 to %d is %d.</p>
                <a class="btn" href="/practice">Try Again</a>
                """.formatted(n, sum));
    }

    @GetMapping("/placements")
    public String placements() {
        return page("Placement Preparation Centre", """
                <h1>Placement Preparation Centre</h1>
                <div class="cards">
                    <div class="card">
                        <h3>Aptitude</h3>
                        <p>Practice quantitative aptitude, reasoning, and verbal ability.</p>
                    </div>
                    <div class="card">
                        <h3>Technical Interviews</h3>
                        <p>Revise programming, data structures, algorithms, and databases.</p>
                    </div>
                    <div class="card">
                        <h3>Communication</h3>
                        <p>Prepare your resume, project explanations, and interview introduction.</p>
                    </div>
                </div>
                """);
    }

    @GetMapping("/roadmap")
    public String roadmap() {
        return page("Your Learning Roadmap", """
                <h1>Your Learning Roadmap</h1>
                <div class="card">
                    <h3>Step 1: Learn Programming</h3>
                    <p>Start with Java or Python fundamentals.</p>
                </div>
                <div class="card">
                    <h3>Step 2: Practice Coding</h3>
                    <p>Solve problems and strengthen your logic.</p>
                </div>
                <div class="card">
                    <h3>Step 3: Build Projects</h3>
                    <p>Create practical applications and publish them on GitHub.</p>
                </div>
                <div class="card">
                    <h3>Step 4: Learn DevOps</h3>
                    <p>Explore Git, Maven, Jenkins, Docker, and CI/CD pipelines.</p>
                </div>
                <div class="card">
                    <h3>Step 5: Prepare for Placements</h3>
                    <p>Practice aptitude tests and technical interviews.</p>
                </div>
                """);
    }
}
