package org.example.taskaroo_todo.service;

import org.example.taskaroo_todo.model.User;
import org.example.taskaroo_todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class PasswordService {
    @Autowired
    private UserRepo userRepo;
    public Boolean reset(String email, String newPass, String confirmPass) {
        if (newPass.equals(confirmPass)) {
            User user = userRepo.findByEmail(email);
            if (user != null) {

                user.setPassword(newPass);
                userRepo.save(user);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
