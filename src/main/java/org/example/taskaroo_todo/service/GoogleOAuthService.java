package org.example.taskaroo_todo.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.example.taskaroo_todo.model.User;
import org.example.taskaroo_todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class GoogleOAuthService {

    private final GoogleIdTokenVerifier verifier;

    @Autowired
    private UserRepo userRepository;

    public GoogleOAuthService() {
        this.verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance())
                .setAudience(Collections.singletonList("484818255394-7fttjna8nsgk0bs3iflncoi95ruestja.apps.googleusercontent.com"))
                .build();
    }

    public GoogleIdToken.Payload verifyToken(String idTokenString) throws Exception {
        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken != null) {
            GoogleIdToken.Payload payload = idToken.getPayload();
            String email = payload.getEmail();

            // Check if user exists
            User existingUser = userRepository.findByEmail(email);
            if (existingUser != null) {
                // User exists, return payload
                return payload;
            } else {
                // User does not exist, create new user
                String name = (String) payload.get("name");
                User newUser = new User();
                newUser.setEmail(email);
                newUser.setName(name);
                userRepository.save(newUser);
                return payload;
            }
        } else {
            throw new Exception("Invalid ID token.");
        }
    }
}