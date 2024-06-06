package edu.lucasrech.todo_list.domain;

import edu.lucasrech.todo_list.domain.enums.Priority;

import java.time.LocalDateTime;

public record TaskUpdateDTO(
        String title,
        String description,
        Priority priority,
        Boolean isCompleted,
        LocalDateTime conclusionDate
) {
}
