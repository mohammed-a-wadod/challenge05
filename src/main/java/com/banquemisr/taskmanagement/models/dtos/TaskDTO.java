package com.banquemisr.taskmanagement.models.dtos;

import com.banquemisr.taskmanagement.models.enums.TaskPriorityEnum;
import com.banquemisr.taskmanagement.models.enums.TaskStatusEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private TaskStatusEnum status;
    private TaskPriorityEnum priority;
    private LocalDate dueDate;
}