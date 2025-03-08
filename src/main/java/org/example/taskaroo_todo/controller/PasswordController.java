package org.example.taskaroo_todo.controller;

import org.example.taskaroo_todo.model.User;
import org.example.taskaroo_todo.repository.UserRepo;
import org.example.taskaroo_todo.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PasswordController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordService passwordService;
    @PutMapping("/reset")
    public ResponseEntity<?> reset(@RequestParam String email, @RequestParam String password, @RequestParam String confirmPassword) {
       Boolean status= passwordService.reset(email, password, confirmPassword);
        if(status) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            return ResponseEntity.ok(response);
        }
        else{
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            return ResponseEntity.ok(response);
        }
    }
}