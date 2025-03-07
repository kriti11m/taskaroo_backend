package org.example.taskaroo_todo.service;

import org.example.taskaroo_todo.model.User;
import org.example.taskaroo_todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepo userRepo;

    public Boolean check(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}