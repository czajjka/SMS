package com.sms.security;

import com.sms.security.model.UserDtls;
import com.sms.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

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

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute UserDtls user){

//        System.out.println(user);
        UserDtls userDtls=userService.createUser(user);
        if(userDtls!=null){
            System.out.println("Register Sucessfully");
        } else {
            System.out.println("Error in server");
        }

        return "redirect:/students/security/register";

    }


}
