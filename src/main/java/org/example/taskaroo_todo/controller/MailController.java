package org.example.taskaroo_todo.controller;

import org.example.taskaroo_todo.model.User;
import org.example.taskaroo_todo.repository.UserRepo;
import org.example.taskaroo_todo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/send")
    public ResponseEntity<?> sendMail(@RequestParam String email) {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            return ResponseEntity.ok(response);
        }
        else {
            String subject = "Password Reset";
            String text = "click here to reset your password  https://kriti11m.github.io/taskaroo_frontend/taskaroo9.html";
            mailService.sendEmail(email, subject, text);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            return ResponseEntity.ok(response);
        }
    }
}