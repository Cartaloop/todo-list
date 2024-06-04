package edu.lucasrech.todo_list.domain;

import edu.lucasrech.todo_list.domain.enums.Priority;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Task(TaskDTO taskDTO) {
        this.title = taskDTO.title();
        this.description = taskDTO.description();
        this.priority = taskDTO.priority();
        this.completed = false;
        this.createdAt = LocalDateTime.now();
        this.finishedAt = taskDTO.finishedDate();
    }

    public Task(TaskUpdateDTO updateDTO) {
        this.title = updateDTO.title();
        this.description = updateDTO.description();
        this.priority = updateDTO.priority();
        this.completed = updateDTO.isCompleted();
        this.createdAt = getCreatedAt();
        this.finishedAt = updateDTO.finishedDate();
    }

}
