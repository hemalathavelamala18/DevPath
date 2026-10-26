
package com.devpath.devpath;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String registered,
            Model model) {

        if (error != null) {
            model.addAttribute(
                    "error",
                    "Invalid username or password. Please try again.");
        }

        if (registered != null) {
            model.addAttribute(
                    "success",
                    "Registration successful! Please log in.");
        }

        return "login";
    }
}
