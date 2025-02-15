package org.example.taskaroo_todo.service;

import org.example.taskaroo_todo.model.User;
import org.example.taskaroo_todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    private User user;
    public String check(String email, String password) {
      user=userRepo.findByEmailAndPassword(email, password);
      if(user!=null){
          return "Login successful";
      }
      else{
          return "Login failed";
      }

    }
}
