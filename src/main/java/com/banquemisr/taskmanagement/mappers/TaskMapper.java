package com.banquemisr.taskmanagement.mappers;

import com.banquemisr.taskmanagement.models.dtos.TaskDTO;
import com.banquemisr.taskmanagement.models.entites.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO toDto(Task task);

    List<TaskDTO> toDtos(List<Task> task);

    @Mapping(expression = "java(dto.getDueDate().atStartOfDay())", target = "dueDate")
    Task toEntity(TaskDTO dto);
}
