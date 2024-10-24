package banquemisr.challenge05.taskmanagement.models.dtos;

import banquemisr.challenge05.taskmanagement.models.enums.TaskPriorityEnum;
import banquemisr.challenge05.taskmanagement.models.enums.TaskStatusEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class TaskDTO {
    private Long id;

    @NotBlank(message = "Task title must have value")
    private String title;

    @NotNull(message = "Task status must have value")
    private TaskStatusEnum status;

    @NotNull(message = "Task priority must have value ")
    private TaskPriorityEnum priority;

    @NotNull(message = "Task due date must have value")
    private LocalDate dueDate;

    private String description;

    @NotNull(message = "User task mail must have value")
    private String userTaskMail;
}
