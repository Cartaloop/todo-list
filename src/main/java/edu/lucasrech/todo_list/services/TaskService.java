package edu.lucasrech.todo_list.services;

import edu.lucasrech.todo_list.domain.TaskResponseDTO;
import edu.lucasrech.todo_list.domain.Task;
import edu.lucasrech.todo_list.domain.TaskDTO;
import edu.lucasrech.todo_list.domain.TaskUpdateDTO;
import edu.lucasrech.todo_list.exceptions.ControllerExceptionHandler;
import edu.lucasrech.todo_list.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponseDTO> getAllTasks() throws Exception {
        if (taskRepository.findAll().isEmpty()) {
            throw new Exception("Não há tarefas");
        }
        return taskRepository.findAllDTO();
    }

    public List<TaskResponseDTO> newTask(TaskDTO task) throws Exception {
        var newTask = new Task(task);
        taskRepository.save(newTask);
        return getAllTasks();
    }

    public List<TaskResponseDTO> updateTask(TaskUpdateDTO task, Long id) throws Exception {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if(taskOptional.isEmpty()) {
            throw new Exception("Tarefa não localizada");
        }

        Task existingTask = taskOptional.get();
        existingTask.setTitle(task.title());
        existingTask.setDescription(task.description());
        existingTask.setPriority(task.priority());
        existingTask.setCompleted(task.isCompleted());
        existingTask.setFinishedAt(task.conclusionDate());

        taskRepository.save(existingTask);
        return getAllTasks();
    }

    public List<TaskResponseDTO> deleteTask(Long taskId) throws Exception {
        if(!taskRepository.existsById(taskId)) {
            throw new EntityNotFoundException("Nenhuma entidade encontrada");
        }
        taskRepository.deleteById(taskId);
        return getAllTasks();
    }


}
