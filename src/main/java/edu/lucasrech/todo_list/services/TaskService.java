package edu.lucasrech.todo_list.services;

import edu.lucasrech.todo_list.domain.Task;
import edu.lucasrech.todo_list.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task newTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) throws Exception {
        if(!taskRepository.existsById(task.getId())) {
            throw new Exception("Tarefa não encontrada");
        }
        return taskRepository.save(task);
    }

    public List<Task> deleteTask(Task task) throws Exception {
        if(!taskRepository.existsById(task.getId())) {
            throw new Exception("Tarefa a ser excluída não foi encontrada");
        }
        taskRepository.deleteById(task.getId());
        return taskRepository.findAll();
    }


}
