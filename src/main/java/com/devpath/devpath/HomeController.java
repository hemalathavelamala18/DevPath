
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
                <html>
                <head>
                    <title>DevPath - Learn and Grow</title>
                </head>
                <body style="font-family: Arial; text-align: center; margin-top: 100px;">
                    <h1>Welcome to DevPath!</h1>
                    <h2>Your Programming Learning and Placement Preparation Portal</h2>
                    <p>Learn coding. Build projects. Prepare for placements.</p>
                </body>
                </html>
                """;
    }
}

