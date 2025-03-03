package org.example.taskaroo_todo.controller;

import org.example.taskaroo_todo.model.User;
import org.example.taskaroo_todo.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin(origins ={
        "http://127.0.0.1:5500","https://ottawa-zambia-bar-ashley.trycloudflare.com/"
})
@RestController
// Add your frontend URL here
public class signupController {
    User user = new User();
    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        signupService.signup(name, email, password);;
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "User created");
        return ResponseEntity.ok(response);
    }
}