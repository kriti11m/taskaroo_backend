package org.example.taskaroo_todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Data
public class User {


    @Id
    @Column(name="user_id",unique = true,nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userid;
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    @Column(name="name")
    private String name;
    @Column(name="password")
    private String password;
    @Column(name="firebase_uid")
    private String firebase_uid;



}
