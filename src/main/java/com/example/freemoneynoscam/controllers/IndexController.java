package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.services.EmailValidator;
import com.example.freemoneynoscam.services.Database;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    EmailValidator validator = new EmailValidator();
    Database database = new Database();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/fail")
    public String fail() {
        return "fail";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @PostMapping("/")
    public String postContact(@RequestParam MultiValueMap body) {
        database.setConnection();

        String result = "fail";

        String input = String.valueOf(body.get("email"));
        input.replace("[","");
        input.replace("]","");
        System.out.println(input);

        // Validate email
        if (validator.validate(input)) {
            if(database.saveEmail(input) == 200) {
                result = "success";
            } else {
                result = "error";
            }
        } else {
            result = "fail";
        }

        // Handle redirect
        if (result == "fail") {
            return "redirect:/fail";
        }

        if (result == "success") {
            return "redirect:/success";
        }

        if (result == "error") {
            return "redirect:/error";
        }

        return "index";
    }
}
