package com.banquemisr.taskmanagement.repository;

import com.banquemisr.taskmanagement.models.entites.Task;
import com.banquemisr.taskmanagement.models.enums.TaskPriorityEnum;
import com.banquemisr.taskmanagement.models.enums.TaskStatusEnum;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT task \n" +
            "FROM Task  task \n" +
            "WHERE (:title IS NULL OR task.title like %:title%) \n" +
            "   AND (:description IS NULL OR task.description like %:description%) \n" +
            "   AND (:status IS NULL OR task.status = :status) \n" +
            "   AND (:priority IS NULL OR task.priority = :priority) \n" +
            "   AND (:fromDueDate IS NULL OR task.dueDate >= :fromDueDate) \n" +
            "   AND (:toDueDate IS NULL OR task.dueDate <= :toDueDate) " +
            "ORDER BY task.id \n")
    PageImpl<Task> searchTasks(
            @Param("title") String title,
            @Param("description") String description,
            @Param("status") TaskStatusEnum status,
            @Param("priority") TaskPriorityEnum priority,
            @Param("fromDueDate") LocalDateTime fromDueDate,
            @Param("toDueDate") LocalDateTime toDueDate,
            Pageable pageable);

    List<Task> findByStatusInAndDueDateLessThanEqual(
            @Param("status") List<TaskStatusEnum> status,
            @Param("toDueDate") LocalDateTime toDueDate
    );
}
