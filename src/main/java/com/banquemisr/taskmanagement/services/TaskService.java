package com.banquemisr.taskmanagement.services;

import com.banquemisr.exception.ResourceNotFoundException;
import com.banquemisr.taskmanagement.mappers.TaskMapper;
import com.banquemisr.taskmanagement.models.dtos.PageDTO;
import com.banquemisr.taskmanagement.models.dtos.TaskDTO;
import com.banquemisr.taskmanagement.models.dtos.TaskSearchDTO;
import com.banquemisr.taskmanagement.models.entites.Task;
import com.banquemisr.taskmanagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public List<TaskDTO> findAll() {
        return taskRepository.findAll().stream().map(taskMapper::toDto).collect(Collectors.toList());
    }

    public PageDTO searchTasks(TaskSearchDTO dto) {
        Pageable pageable = PageRequest.of(
                Optional.ofNullable(dto.getPageNumber()).orElse(0),
                Optional.ofNullable(dto.getPageSize()).orElse(10)
        );
        PageImpl<Task> data = taskRepository.searchTasks(dto.getTitle(),
                dto.getDescription(),
                dto.getStatus(),
                dto.getPriority(),
                dto.getFromDueDate().atStartOfDay(),
                dto.getToDueDate().atTime(LocalTime.MAX),
                pageable);

        return new PageDTO(
                CollectionUtils.isEmpty(data.getContent()) ? new ArrayList<>() : taskMapper.toDtos(data.getContent()),
                data.getTotalPages(),
                data.getTotalElements()
        );
    }

    public TaskDTO findById(Long id) {
        return taskMapper.toDto(getTaskById(id));
    }

    public TaskDTO save(TaskDTO dto) {
        Task savedTask = taskRepository.save(taskMapper.toEntity(dto));
        return taskMapper.toDto(savedTask);
    }

    public TaskDTO update(TaskDTO dto) {
        getTaskById(dto.getId());
        Task task = taskMapper.toEntity(dto);
        return taskMapper.toDto(taskRepository.save(task));
    }

    public void deleteById(Long id) {
        getTaskById(id);
        taskRepository.deleteById(id);
    }

    private Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }
}
