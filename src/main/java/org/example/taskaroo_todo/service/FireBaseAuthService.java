// FireBaseAuthService.java
package org.example.taskaroo_todo.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.example.taskaroo_todo.model.User;
import org.example.taskaroo_todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FireBaseAuthService {

    @Autowired
    private UserRepo userRepo;

    public FirebaseToken verifyToken(String idToken) throws FirebaseAuthException {
        FirebaseToken decoded = FirebaseAuth.getInstance().verifyIdToken(idToken);
        User user = new User();
        user.setFirebaseUid(decoded.getUid());
        user.setEmail(decoded.getEmail());

        userRepo.save(user);
        return decoded;
    }
}