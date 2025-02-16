package org.example.taskaroo_todo.controller;

import org.example.taskaroo_todo.model.Task;
import org.example.taskaroo_todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public String addTask(@RequestBody Task task, @RequestParam String gmail) {
        taskService.addTask(task, gmail);
        return "Task added";
    }
}