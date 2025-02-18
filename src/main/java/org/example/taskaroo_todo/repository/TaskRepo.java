package org.example.taskaroo_todo.repository;

import org.example.taskaroo_todo.model.Task;
import org.example.taskaroo_todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {


    List<Task> findAllByUserAndStatus(User user, String pending);
}
