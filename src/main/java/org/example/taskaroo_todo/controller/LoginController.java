package org.example.taskaroo_todo.controller;

import org.example.taskaroo_todo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        String verify=loginService.check(email,password);
        return verify;
    }
}
