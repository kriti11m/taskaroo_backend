package org.example.taskaroo_todo.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.example.taskaroo_todo.service.GoogleOAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private GoogleOAuthService googleOAuthService;

    @PostMapping("/verifyToken")
    public ResponseEntity<?> verifyToken(@RequestHeader String idToken) {
        try {
            GoogleIdToken.Payload payload = googleOAuthService.verifyToken(idToken);
            return ResponseEntity.ok(payload);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid token");
        }
    }
}