package banquemisr.challenge05.taskmanagement.mappers;

import banquemisr.challenge05.taskmanagement.models.dtos.TaskDTO;
import banquemisr.challenge05.taskmanagement.models.entites.Task;
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
