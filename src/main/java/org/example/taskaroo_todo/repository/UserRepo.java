package org.example.taskaroo_todo.repository;

import org.example.taskaroo_todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);

    User findByEmail(String gmail);
}