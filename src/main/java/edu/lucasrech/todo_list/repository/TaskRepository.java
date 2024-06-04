package edu.lucasrech.todo_list.repository;

import edu.lucasrech.todo_list.domain.Task;
import edu.lucasrech.todo_list.domain.TaskResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT new edu.lucasrech.todo_list.domain.TaskResponseDTO(t.id ,t.title, t.description, t.completed, t.priority, t.createdAt, t.finishedAt) FROM Task t")
    List<TaskResponseDTO> findAllDTO();
}
