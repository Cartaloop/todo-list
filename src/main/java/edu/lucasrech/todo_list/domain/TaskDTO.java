package edu.lucasrech.todo_list.domain;

import edu.lucasrech.todo_list.domain.enums.Priority;

import java.time.LocalDateTime;

public record TaskDTO(
String title,
String description,
Priority priority,
LocalDateTime conclusionDate
) {
}
