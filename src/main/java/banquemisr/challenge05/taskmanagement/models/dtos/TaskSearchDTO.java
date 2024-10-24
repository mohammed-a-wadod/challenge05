package banquemisr.challenge05.taskmanagement.models.dtos;

import banquemisr.challenge05.taskmanagement.models.enums.TaskPriorityEnum;
import banquemisr.challenge05.taskmanagement.models.enums.TaskStatusEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskSearchDTO {

    private String title;
    private String description;
    private TaskStatusEnum status;
    private TaskPriorityEnum priority;
    private LocalDate fromDueDate;
    private LocalDate toDueDate;
    private Integer pageNumber;
    private Integer pageSize;
}
