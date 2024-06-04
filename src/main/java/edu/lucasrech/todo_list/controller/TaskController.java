package edu.lucasrech.todo_list.controller;

import edu.lucasrech.todo_list.domain.TaskResponseDTO;
import edu.lucasrech.todo_list.domain.TaskDTO;
import edu.lucasrech.todo_list.domain.TaskUpdateDTO;
import edu.lucasrech.todo_list.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TaskController {

    TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping
    public ResponseEntity<List<TaskResponseDTO>> createTask(@RequestBody TaskDTO task) {
        return ResponseEntity.ok(taskService.newTask(task));
    }

    @DeleteMapping
    public ResponseEntity<List<TaskResponseDTO>> deleteTask(@RequestBody Long id) throws Exception {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

    @PutMapping
    public ResponseEntity<List<TaskResponseDTO>> updateTask(@RequestBody TaskUpdateDTO task, Long id) throws Exception {
        return ResponseEntity.ok(taskService.updateTask(task, id));
    }
}
