package com.banquemisr.taskmanagement.mappers;

import com.banquemisr.taskmanagement.models.dtos.TaskDTO;
import com.banquemisr.taskmanagement.models.entites.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO toDto(Task task);

    List<TaskDTO> toDtos(List<Task> task);

    Task toEntity(TaskDTO dto);
}
