
package com.devpath.devpath;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(
            AppUserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        username = username.trim();
        email = email.trim().toLowerCase();

        if (!username.matches("[A-Za-z0-9_.-]{3,50}")) {
            model.addAttribute("error",
                    "Username must be 3–50 characters using letters, numbers, dots, underscores or hyphens.");
            return "register";
        }

        if (email.length() > 150
                || !email.matches(
                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            model.addAttribute("error", "Enter a valid email address.");
            return "register";
        }

        if (password.length() < 8 || password.length() > 72) {
            model.addAttribute("error",
                    "Password must contain 8–72 characters.");
            return "register";
        }

        if (userRepository.existsByUsernameIgnoreCase(username)) {
            model.addAttribute("error", "Username already exists.");
            return "register";
        }

        if (userRepository.existsByEmailIgnoreCase(email)) {
            model.addAttribute("error", "Email is already registered.");
            return "register";
        }

        String hashedPassword = passwordEncoder.encode(password);

        userRepository.save(
                new AppUser(username, email, hashedPassword));

        return "redirect:/login?registered";
    }
}
