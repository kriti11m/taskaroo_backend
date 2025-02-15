package org.example.taskaroo_todo.controller;

import org.example.taskaroo_todo.model.User;
import org.example.taskaroo_todo.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class signupController {
    User user = new User();
    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public String signup(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        signupService.signup(name, email, password);
        return "User created";
    }
}