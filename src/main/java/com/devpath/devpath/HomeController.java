
package com.devpath.devpath;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>DevPath | Learn and Grow</title>
                    <style>
                        body {
                            margin: 0;
                            font-family: Arial, sans-serif;
                            background: #f4f7fb;
                            color: #1e293b;
                        }
                        nav {
                            background: #172554;
                            padding: 20px;
                            text-align: center;
                        }
                        nav a {
                            color: white;
                            text-decoration: none;
                            margin: 0 12px;
                            font-weight: bold;
                        }
                        header {
                            background: #2563eb;
                            color: white;
                            text-align: center;
                            padding: 70px 20px;
                        }
                        header h1 {
                            font-size: 42px;
                            margin-bottom: 15px;
                        }
                        header p {
                            font-size: 18px;
                        }
                        main {
                            max-width: 1000px;
                            margin: 35px auto;
                            padding: 0 20px;
                        }
                        .cards {
                            display: grid;
                            grid-template-columns:
                                repeat(auto-fit, minmax(220px, 1fr));
                            gap: 20px;
                        }
                        .card {
                            background: white;
                            padding: 25px;
                            border-radius: 12px;
                            box-shadow: 0 4px 12px #00000012;
                        }
                        .card h3 {
                            color: #2563eb;
                        }
                        footer {
                            text-align: center;
                            padding: 22px;
                            background: #172554;
                            color: white;
                        }
                    </style>
                </head>
                <body>
                    <nav>
                        <a href="/">Home</a>
                        <a href="/courses">Courses</a>
                        <a href="#practice">Coding Practice</a>
                        <a href="#placements">Placements</a>
                    </nav>

                    <header>
                        <h1>Welcome to DevPath!</h1>
                        <p>Your Programming Learning and Placement Preparation Portal</p>
                        <p>Learn coding. Build projects. Prepare for placements.</p>
                    </header>

                    <main>
                        <h2>Explore DevPath</h2>
                        <div class="cards">
                            <section class="card" id="courses">
                                <h3>Programming Courses</h3>
                                <p>Build your foundation in Java,
                                Python, and web development.</p>
                                <a href="/courses">Explore Courses</a>
                            </section>

                            <section class="card" id="practice">
                                <h3>Coding Practice</h3>
                                <p>Improve your problem-solving skills
                                with coding exercises.</p>
                            </section>

                            <section class="card" id="placements">
                                <h3>Placement Preparation</h3>
                                <p>Prepare for technical interviews,
                                aptitude tests, and job opportunities.</p>
                            </section>
                        </div>
                    </main>

                    <footer>
                        <p>DevPath - Learn, Practice, Succeed!</p>
                    </footer>
                </body>
                </html>
                """;
    }

    @GetMapping("/courses")
    @ResponseBody
    public String courses() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>DevPath | Courses</title>
                    <style>
                        body {
                            margin: 0;
                            font-family: Arial, sans-serif;
                            background: #f4f7fb;
                            color: #1e293b;
                        }
                        nav {
                            background: #172554;
                            padding: 20px;
                            text-align: center;
                        }
                        nav a {
                            color: white;
                            text-decoration: none;
                            margin: 0 12px;
                            font-weight: bold;
                        }
                        main {
                            max-width: 1000px;
                            margin: 40px auto;
                            padding: 0 20px;
                        }
                        .cards {
                            display: grid;
                            grid-template-columns:
                                repeat(auto-fit, minmax(220px, 1fr));
                            gap: 20px;
                        }
                        .card {
                            background: white;
                            padding: 25px;
                            border-radius: 12px;
                            box-shadow: 0 4px 12px #00000012;
                        }
                        h1, h3 {
                            color: #2563eb;
                        }
                        footer {
                            text-align: center;
                            padding: 22px;
                            background: #172554;
                            color: white;
                            margin-top: 40px;
                        }
                    </style>
                </head>
                <body>
                    <nav>
                        <a href="/">Home</a>
                        <a href="/courses">Courses</a>
                    </nav>

                    <main>
                        <h1>Explore Our Courses</h1>
                        <p>Choose a learning path and build your skills.</p>

                        <div class="cards">
                            <section class="card">
                                <h3>Java Programming</h3>
                                <p>Learn Java basics, object-oriented
                                programming, collections, and exceptions.</p>
                            </section>

                            <section class="card">
                                <h3>Python Programming</h3>
                                <p>Learn Python syntax, functions,
                                data structures, and problem solving.</p>
                            </section>

                            <section class="card">
                                <h3>Web Development</h3>
                                <p>Explore HTML, CSS, JavaScript,
                                and web application development.</p>
                            </section>
                        </div>
                    </main>

                    <footer>
                        <p>DevPath - Learn, Practice, Succeed!</p>
                    </footer>
                </body>
                </html>
                """;
    }
}
