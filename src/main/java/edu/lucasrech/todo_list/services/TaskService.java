package edu.lucasrech.todo_list.services;

import edu.lucasrech.todo_list.domain.TaskResponseDTO;
import edu.lucasrech.todo_list.domain.Task;
import edu.lucasrech.todo_list.domain.TaskDTO;
import edu.lucasrech.todo_list.domain.TaskUpdateDTO;
import edu.lucasrech.todo_list.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAllDTO();
    }

    public List<TaskResponseDTO> newTask(TaskDTO task) {
        var newTask = new Task(task);
        taskRepository.save(newTask);
        return getAllTasks();
    }

    public List<TaskResponseDTO> updateTask(TaskUpdateDTO task, Long id) throws Exception {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if(taskOptional.isEmpty()) {
            throw new Exception("Tarefa não encontrada");
        }

        Task existingTask = taskOptional.get();
        existingTask.setTitle(task.title());
        existingTask.setDescription(task.description());
        existingTask.setPriority(task.priority());
        existingTask.setCompleted(task.isCompleted());
        existingTask.setFinishedAt(task.finishedDate());

        taskRepository.save(existingTask);
        return getAllTasks();
    }

    public List<TaskResponseDTO> deleteTask(Long taskId) throws Exception {
        if(!taskRepository.existsById(taskId)) {
            throw new Exception("Tarefa a ser excluída não foi encontrada");
        }
        taskRepository.deleteById(taskId);
        return getAllTasks();
    }


}
