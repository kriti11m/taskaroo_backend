package org.example.taskaroo_todo.controller;

import org.example.taskaroo_todo.model.Task;
import org.example.taskaroo_todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public ResponseEntity<Map<String,Object>> addTask(@RequestBody Task task, @RequestParam String gmail) {
        taskService.addTask(task, gmail);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Task created");
        return ResponseEntity.ok(response);
    }
}