package org.example.taskaroo_todo.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.example.taskaroo_todo.service.FireBaseAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private FireBaseAuthService firebaseAuthService;

    @PostMapping("/verifyToken")
    public ResponseEntity<?> verifyToken(@RequestHeader String idToken) {
        try {
            FirebaseToken decodedToken = firebaseAuthService.verifyToken(idToken);

            return ResponseEntity.ok(decodedToken);
        } catch (FirebaseAuthException e) {
            return ResponseEntity.status(401).body("Invalid token");
        }
    }
}