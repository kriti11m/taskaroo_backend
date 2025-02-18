package org.example.taskaroo_todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskid")
    private int task_id;
    @Column(name = "task_desc")
    private String task_desc;
    @Column(name = "due_date")
    private Date due_date;
    @Column(name = "due_time")
    private LocalTime due_time;
    @Column(name = "priority_level")
    private String priority_level;
    @Column(name = "notes")
    private String Notes;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}