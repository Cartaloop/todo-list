package edu.lucasrech.todo_list.domain;

import edu.lucasrech.todo_list.domain.enums.Priority;

import java.time.LocalDateTime;

public record TaskResponseDTO(
        Long id,
        String title,
        String description,
        Boolean isCompleted,
        Priority priority,
        LocalDateTime creationDate,
        LocalDateTime conclusionDate
) {
}
