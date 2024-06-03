package edu.lucasrech.todo_list.controller;

import edu.lucasrech.todo_list.domain.Task;
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
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping
    public ResponseEntity<List<Task>> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.newTask(task));
    }

    @DeleteMapping
    public ResponseEntity<List<Task>> deleteTask(@RequestBody Long id) throws Exception {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

    @PutMapping
    public ResponseEntity<List<Task>> updateTask(@RequestBody Task task) throws Exception {
        return ResponseEntity.ok(taskService.updateTask(task));
    }
}
