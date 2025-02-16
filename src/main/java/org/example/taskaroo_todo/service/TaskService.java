package org.example.taskaroo_todo.service;

import org.example.taskaroo_todo.model.Task;
import org.example.taskaroo_todo.model.User;
import org.example.taskaroo_todo.repository.TaskRepo;
import org.example.taskaroo_todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private UserRepo userRepo;

    public void addTask(Task task, String gmail) {
        User user = userRepo.findByEmail(gmail);
        if (user != null) {
            task.setUser(user);
            taskRepo.save(task);
        } else {
            throw new IllegalArgumentException("User with Gmail " + gmail + " not found");
        }
    }
}