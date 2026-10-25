
package com.devpath.devpath;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private String page(String title, String body) {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport"
                          content="width=device-width, initial-scale=1.0">
                    <title>%s | DevPath</title>
                    <style>
                        * { box-sizing: border-box; }
                        body {
                            margin: 0;
                            font-family: Arial, sans-serif;
                            background: #f4f7fb;
                            color: #1e293b;
                            line-height: 1.6;
                        }
                        nav {
                            background: #172554;
                            padding: 17px;
                            display: flex;
                            justify-content: center;
                            flex-wrap: wrap;
                            gap: 22px;
                        }
                        nav a {
                            color: white;
                            text-decoration: none;
                            font-weight: bold;
                        }
                        nav a:hover { color: #93c5fd; }
                        header {
                            background: linear-gradient(120deg,#1d4ed8,#4338ca);
                            color: white;
                            padding: 55px 20px;
                            text-align: center;
                        }
                        header h1 {
                            font-size: clamp(30px,5vw,46px);
                            margin: 0 0 12px;
                        }
                        main {
                            max-width: 1050px;
                            margin: 35px auto;
                            padding: 0 20px;
                        }
                        .cards {
                            display: grid;
                            grid-template-columns:
                                repeat(auto-fit,minmax(230px,1fr));
                            gap: 20px;
                        }
                        .card {
                            background: white;
                            padding: 23px;
                            border-radius: 14px;
                            box-shadow: 0 4px 15px #0000000d;
                            border: 1px solid #e2e8f0;
                        }
                        h2, h3 { color: #1d4ed8; }
                        .button {
                            display: inline-block;
                            background: #2563eb;
                            color: white;
                            padding: 10px 16px;
                            border-radius: 7px;
                            text-decoration: none;
                            border: 0;
                            cursor: pointer;
                            font-size: 15px;
                            margin-top: 8px;
                        }
                        .button:hover { background: #1d4ed8; }
                        .secondary {
                            background: #e0e7ff;
                            color: #1e3a8a;
                        }
                        pre {
                            background: #0f172a;
                            color: #e2e8f0;
                            padding: 18px;
                            border-radius: 9px;
                            overflow-x: auto;
                        }
                        .notice {
                            background: #dbeafe;
                            padding: 15px;
                            border-radius: 9px;
                        }
                        li { margin-bottom: 8px; }
                        input[type=radio], input[type=checkbox] {
                            margin-right: 9px;
                        }
                        footer {
                            margin-top: 45px;
                            background: #172554;
                            color: white;
                            padding: 22px;
                            text-align: center;
                        }
                        footer a { color: #bfdbfe; }
                    </style>
                </head>
                <body>
                    <nav>
                        <a href="/">Home</a>
                        <a href="/courses">Courses</a>
                        <a href="/practice">Coding Practice</a>
                        <a href="/placements">Placements</a>
                        <a href="/roadmap">Learning Roadmap</a>
                    </nav>
                    %s
                    <footer>
                        <p>DevPath | Learn, Practice, Succeed!</p>
                        <a href="/">Back to Home</a>
                    </footer>
                </body>
                </html>
                """.formatted(title, body);
    }

    @GetMapping("/")
    @ResponseBody
    public String home() {
        String body = """
                <header>
                    <h1>Your journey from learner to developer starts here.</h1>
                    <p>Learn programming, practise real problems,
                       and prepare for your first tech job.</p>
                    <a class="button" href="/roadmap">Start Learning</a>
                </header>
                <main>
                    <div class="notice">
                        <strong>New to coding?</strong>
                        Start with the learning roadmap, study one lesson,
                        practise the examples, and move forward at your own pace.
                    </div>
                    <h2>What do you want to achieve?</h2>
                    <div class="cards">
                        <section class="card">
                            <h3>Learn Programming</h3>
                            <p>Understand Java, Python and web development
                               with beginner-friendly lessons and examples.</p>
                            <a class="button" href="/courses">Explore Courses</a>
                        </section>
                        <section class="card">
                            <h3>Practise Coding</h3>
                            <p>Try programming questions, check answers,
                               and understand why a solution works.</p>
                            <a class="button" href="/practice">Start Practice</a>
                        </section>
                        <section class="card">
                            <h3>Prepare for Placements</h3>
                            <p>Revise technical topics, practise aptitude,
                               and follow a preparation checklist.</p>
                            <a class="button" href="/placements">Prepare Now</a>
                        </section>
                    </div>
                    <h2>Your suggested learning path</h2>
                    <ol>
                        <li>Learn programming fundamentals.</li>
                        <li>Write small programs every day.</li>
                        <li>Study data structures and problem solving.</li>
                        <li>Build projects and learn Git.</li>
                        <li>Prepare your resume and practise interviews.</li>
                    </ol>
                </main>
                """;
        return page("Home", body);
    }

    @GetMapping("/courses")
    @ResponseBody
    public String courses() {
        String body = """
                <main>
                    <h1>Explore Programming Courses</h1>
                    <p>Choose a course, study the lesson, and practise
                       what you learn.</p>
                    <div class="cards">
                        <section class="card">
                            <h3>Java Programming</h3>
                            <p>Variables, conditions, loops, methods
                               and object-oriented programming.</p>
                            <p><strong>Level:</strong> Beginner</p>
                            <a class="button" href="/courses/java">Start Java</a>
                        </section>
                        <section class="card">
                            <h3>Python Programming</h3>
                            <p>Variables, collections, conditions,
                               loops and functions.</p>
                            <p><strong>Level:</strong> Beginner</p>
                            <a class="button" href="/courses/python">Start Python</a>
                        </section>
                        <section class="card">
                            <h3>Web Development</h3>
                            <p>Build web pages with HTML, style them
                               with CSS, and add JavaScript.</p>
                            <p><strong>Level:</strong> Beginner</p>
                            <a class="button" href="/courses/web">Start Web Development</a>
                        </section>
                    </div>
                    <p class="notice">Learning tip: read the lesson,
                       try the example yourself, and then solve a practice
                       question without looking at the answer.</p>
                </main>
                """;
        return page("Courses", body);
    }

    @GetMapping("/courses/java")
    @ResponseBody
    public String javaLesson() {
        String body = """
                <main>
                    <h1>Java Programming: Lesson 1</h1>
                    <p><strong>Goal:</strong> Understand a simple Java
                       program and how it prints output.</p>
                    <h2>What is Java?</h2>
                    <p>Java is a programming language used to build
                       backend services, enterprise applications and more.</p>
                    <h2>Your first example</h2>
                    <pre>public class Main {
                    public static void main(String[] args) {
                        System.out.println("Hello, DevPath!");
                    }
                }</pre>
                    <h2>Understand the code</h2>
                    <ul>
                        <li><code>class Main</code> declares a class.</li>
                        <li><code>main</code> is the program entry point.</li>
                        <li><code>System.out.println</code> prints a line.</li>
                    </ul>
                    <h2>Try it yourself</h2>
                    <p>Change the message to your name or print
                       the result of a simple addition.</p>
                    <div class="notice">
                        <strong>Practice task:</strong>
                        Write a Java program that prints the numbers
                        1, 2 and 3 on separate lines.
                    </div>
                    <a class="button" href="/practice">Try Practice Questions</a>
                    <a class="button secondary" href="/courses">All Courses</a>
                </main>
                """;
        return page("Java Lesson", body);
    }

    @GetMapping("/courses/python")
    @ResponseBody
    public String pythonLesson() {
        String body = """
                <main>
                    <h1>Python Programming: Lesson 1</h1>
                    <p><strong>Goal:</strong> Learn variables and output.</p>
                    <h2>What is Python?</h2>
                    <p>Python is a readable programming language used
                       in automation, web development, data analysis
                       and many other areas.</p>
                    <h2>Your first example</h2>
                    <pre>name = "DevPath"
                    print("Hello,", name)</pre>
                    <h2>Understand the code</h2>
                    <ul>
                        <li><code>name</code> stores a string value.</li>
                        <li><code>print()</code> displays output.</li>
                    </ul>
                    <h2>Try it yourself</h2>
                    <p>Create variables for your name and age, then
                       print both values.</p>
                    <a class="button" href="/practice">Try Practice Questions</a>
                    <a class="button secondary" href="/courses">All Courses</a>
                </main>
                """;
        return page("Python Lesson", body);
    }

    @GetMapping("/courses/web")
    @ResponseBody
    public String webLesson() {
        String body = """
                <main>
                    <h1>Web Development: Lesson 1</h1>
                    <p><strong>Goal:</strong> Understand HTML structure
                       and how a browser displays a web page.</p>
                    <h2>What do web technologies do?</h2>
                    <ul>
                        <li>HTML provides the structure.</li>
                        <li>CSS controls the appearance.</li>
                        <li>JavaScript adds interactivity.</li>
                    </ul>
                    <h2>Your first HTML example</h2>
                    <pre>&lt;!DOCTYPE html&gt;
                &lt;html&gt;
                &lt;body&gt;
                    &lt;h1&gt;Hello, DevPath!&lt;/h1&gt;
                    &lt;p&gt;My first web page.&lt;/p&gt;
                &lt;/body&gt;
                &lt;/html&gt;</pre>
                    <h2>Try it yourself</h2>
                    <p>Create a page with your own heading and
                       a paragraph describing your learning goal.</p>
                    <a class="button" href="/practice">Try Practice Questions</a>
                    <a class="button secondary" href="/courses">All Courses</a>
                </main>
                """;
        return page("Web Development Lesson", body);
    }

    @GetMapping("/practice")
    @ResponseBody
    public String practice() {
        String body = """
                <main>
                    <h1>Coding Practice</h1>
                    <p>Answer the questions and submit to see
                       feedback and an explanation.</p>

                    <section class="card">
                        <h2>Question 1: Java output</h2>
                        <p>What does
                           <code>System.out.println(2 + 3);</code>
                           print?</p>
                        <form action="/practice/check" method="get">
                            <label><input type="radio" name="answer"
                                value="4" required>4</label><br>
                            <label><input type="radio" name="answer"
                                value="5">5</label><br>
                            <label><input type="radio" name="answer"
                                value="23">23</label><br>
                            <button class="button" type="submit">Check Answer</button>
                        </form>
                    </section>

                    <section class="card">
                        <h2>Question 2: Programming basics</h2>
                        <p>Which structure repeats instructions?</p>
                        <form action="/practice/check-loop" method="get">
                            <label><input type="radio" name="answer"
                                value="if" required>if statement</label><br>
                            <label><input type="radio" name="answer"
                                value="loop">loop</label><br>
                            <label><input type="radio" name="answer"
                                value="variable">variable</label><br>
                            <button class="button" type="submit">Check Answer</button>
                        </form>
                    </section>
                    <p class="notice">Tip: don't just memorise answers.
                       Run small examples and explain the result in your own words.</p>
                </main>
                """;
        return page("Coding Practice", body);
    }

    @GetMapping("/practice/check")
    @ResponseBody
    public String checkAnswer(@RequestParam String answer) {
        boolean correct = "5".equals(answer);
        String result = correct
                ? "<h2>Correct! Well done.</h2>"
                : "<h2>Not quite. Try again.</h2>";
        String body = """
                <main>
                    <section class="card">
                        %s
                        <p>Explanation: the plus operator adds the
                           integer values 2 and 3, so the result is 5.</p>
                        <a class="button" href="/practice">Try Again</a>
                    </section>
                </main>
                """.formatted(result);
        return page("Practice Result", body);
    }

    @GetMapping("/practice/check-loop")
    @ResponseBody
    public String checkLoop(@RequestParam String answer) {
        boolean correct = "loop".equals(answer);
        String result = correct
                ? "<h2>Correct! A loop repeats instructions.</h2>"
                : "<h2>Try again. Think about repetition.</h2>";
        String body = """
                <main>
                    <section class="card">
                        %s
                        <p>Explanation: loops repeat a block of code
                           while a condition or iteration rule allows it.</p>
                        <a class="button" href="/practice">Try Again</a>
                    </section>
                </main>
                """.formatted(result);
        return page("Practice Result", body);
    }

    @GetMapping("/placements")
    @ResponseBody
    public String placements() {
        String body = """
                <main>
                    <h1>Placement Preparation Centre</h1>
                    <p>Prepare step by step for internships
                       and entry-level software roles.</p>
                    <div class="cards">
                        <section class="card">
                            <h3>Technical Fundamentals</h3>
                            <ul>
                                <li>Revise Java or Python basics.</li>
                                <li>Learn object-oriented programming.</li>
                                <li>Understand SQL and databases.</li>
                                <li>Review operating systems and networking.</li>
                            </ul>
                        </section>
                        <section class="card">
                            <h3>Aptitude and Reasoning</h3>
                            <ul>
                                <li>Percentages and ratios.</li>
                                <li>Time, speed and distance.</li>
                                <li>Number series and logical reasoning.</li>
                                <li>Practise timed questions.</li>
                            </ul>
                        </section>
                        <section class="card">
                            <h3>Interview Preparation</h3>
                            <ul>
                                <li>Explain your projects clearly.</li>
                                <li>Practise common technical questions.</li>
                                <li>Prepare examples of problem solving.</li>
                                <li>Practise introducing yourself.</li>
                            </ul>
                        </section>
                    </div>

                    <h2>My preparation checklist</h2>
                    <p>Tick activities as you complete them.
                       This checklist is saved in this browser.</p>
                    <section class="card">
                        <label><input type="checkbox" data-task="java">
                            Revise programming fundamentals</label><br>
                        <label><input type="checkbox" data-task="coding">
                            Solve five coding problems</label><br>
                        <label><input type="checkbox" data-task="sql">
                            Practise SQL queries</label><br>
                        <label><input type="checkbox" data-task="resume">
                            Update my resume</label><br>
                        <label><input type="checkbox" data-task="interview">
                            Practise a mock interview</label><br>
                        <p id="progress">Progress: 0 of 5 completed</p>
                    </section>
                    <script>
                        const boxes = document.querySelectorAll('[data-task]');
                        boxes.forEach(box => {
                            box.checked = localStorage.getItem(
                                'devpath-' + box.dataset.task) === 'true';
                            box.addEventListener('change', () => {
                                localStorage.setItem(
                                    'devpath-' + box.dataset.task,
                                    box.checked);
                                updateProgress();
                            });
                        });
                        function updateProgress() {
                            const count = [...boxes].filter(b => b.checked).length;
                            document.getElementById('progress').textContent =
                                'Progress: ' + count + ' of ' + boxes.length
                                + ' completed';
                        }
                        updateProgress();
                    </script>
                </main>
                """;
        return page("Placements", body);
    }

    @GetMapping("/roadmap")
    @ResponseBody
    public String roadmap() {
        String body = """
                <main>
                    <h1>Your Learning Roadmap</h1>
                    <p>Follow these steps in order. Focus on understanding
                       concepts and practising regularly.</p>
                    <div class="cards">
                        <section class="card">
                            <h3>Step 1: Foundations</h3>
                            <p>Learn variables, data types, conditions,
                               loops and functions.</p>
                            <a href="/courses/java">Start Java</a>
                            <br><a href="/courses/python">Start Python</a>
                        </section>
                        <section class="card">
                            <h3>Step 2: Problem Solving</h3>
                            <p>Practise arithmetic, strings, arrays,
                               searching and sorting.</p>
                            <a href="/practice">Solve Questions</a>
                        </section>
                        <section class="card">
                            <h3>Step 3: Build Projects</h3>
                            <p>Build a small application, use Git,
                               and learn how to test your code.</p>
                        </section>
                        <section class="card">
                            <h3>Step 4: Placement Preparation</h3>
                            <p>Revise technical concepts, practise aptitude,
                               and prepare to explain your projects.</p>
                            <a href="/placements">Open Placement Centre</a>
                        </section>
                    </div>
                    <h2>A simple weekly routine</h2>
                    <ul>
                        <li>Study a concept for 30 minutes.</li>
                        <li>Write and run examples for 30 minutes.</li>
                        <li>Solve one or two practice questions.</li>
                        <li>Review what you learned at the end of the week.</li>
                    </ul>
                </main>
                """;
        return page("Learning Roadmap", body);
    }
}
