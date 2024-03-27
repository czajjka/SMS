package com.sms.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "students/security/index";
    }

    @GetMapping("/login")
    public String login() {
        return "students/security/login";
    }

    @GetMapping("/register")
    public String register() {
        return "students/security/register";
    }
}
