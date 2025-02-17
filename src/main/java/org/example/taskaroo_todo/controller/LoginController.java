package org.example.taskaroo_todo.controller;

import org.example.taskaroo_todo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestParam String email, @RequestParam String password) {
        String verify=loginService.check(email,password);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "verified");
        return ResponseEntity.ok(response);
    }
}
