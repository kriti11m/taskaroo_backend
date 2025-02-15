package org.example.taskaroo_todo.service;

import org.example.taskaroo_todo.model.User;
import org.example.taskaroo_todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    private UserRepo userRepo;

    public void signup(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userRepo.save(user);


    }
}
