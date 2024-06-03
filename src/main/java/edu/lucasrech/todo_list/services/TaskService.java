package edu.lucasrech.todo_list.services;

import edu.lucasrech.todo_list.repository.TaskRepository;

public class TaskService {

    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


}
