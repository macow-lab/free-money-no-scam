package com.example.freemoneynoscam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

	@PostMapping("/contact")
	public String postContact(@RequestParam MultiValueMap body ) {
		System.out.print(body);
	    String result = "";
        String input = String.valueOf(body.get("email"));
        System.out.println(input);


            // Handle redirect
            if (result.equals("400")) {
                return "fail";
            }

            if (result.equals("200")) {
                return "success";
            }
            
            return "contact";
		} 
	}
