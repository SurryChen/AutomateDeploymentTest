package com.somecode.automatedeploymenttest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/auto")
public class AutoController {

    @GetMapping("/deploy")
    public String deploy() {
        return "Success!";
    }

    @GetMapping("/dev")
    public String dev() {
        return "Dev Success!";
    }

    @GetMapping("/deploys")
    public String deploys() {
        return "You are success!";
    }

}
