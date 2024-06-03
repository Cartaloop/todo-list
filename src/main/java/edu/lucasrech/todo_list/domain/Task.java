package edu.lucasrech.todo_list.domain;

import edu.lucasrech.todo_list.domain.enums.Priority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String title;
    private String description;
    @Column(name = "is_completed")
    private boolean completed;
    private Priority priority;
    @Column(name = "creation_date")
    private LocalDateTime createdAt;
    @Column(name = "conclusion_date")
    private LocalDateTime finishedAt;

}
