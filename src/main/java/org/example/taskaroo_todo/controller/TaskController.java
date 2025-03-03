package org.example.taskaroo_todo.controller;

import org.example.taskaroo_todo.model.Task;
import org.example.taskaroo_todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public ResponseEntity<Map<String, Object>> addTask(@RequestBody Task task, @RequestParam String gmail) {
        task.setStatus("pending");
        taskService.addTask(task, gmail);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Task created");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pendingTask")
    public ResponseEntity<Map<String, Object>> pendingTask(@RequestParam String email) {
        List<Task> tasks = taskService.ShowPendingTask(email);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("tasks", tasks);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/completedTask")
    public List completedTasks(@RequestParam String email) {
        List<Task> tasks = taskService.ShowCompletedTasks(email);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("tasks", tasks);
        return tasks;
    }
    @PutMapping("/done")
    public ResponseEntity<Map<String, Object>> done(@RequestParam int id) {
        taskService.done(id);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Task completed");
        return ResponseEntity.ok(response);
    }
}