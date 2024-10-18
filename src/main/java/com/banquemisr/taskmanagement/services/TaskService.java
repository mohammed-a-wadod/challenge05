package com.banquemisr.taskmanagement.services;

import com.banquemisr.taskmanagement.exception.ResourceNotFoundException;
import com.banquemisr.taskmanagement.mappers.TaskMapper;
import com.banquemisr.taskmanagement.models.dtos.PageDTO;
import com.banquemisr.taskmanagement.models.dtos.TaskDTO;
import com.banquemisr.taskmanagement.models.dtos.TaskSearchDTO;
import com.banquemisr.taskmanagement.models.entites.Task;
import com.banquemisr.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    public List<TaskDTO> findAll() {
        return taskRepository.findAll().stream().map(taskMapper::toDto).collect(Collectors.toList());
    }

    public PageDTO searchTasks(TaskSearchDTO dto) {
        Pageable pageable = PageRequest.of(
                (Objects.nonNull(dto.getPageNumber()) ? dto.getPageNumber() : 0),
                (Objects.nonNull(dto.getPageSize()) ? dto.getPageSize() : 10)
        );
        PageImpl<Task> data = taskRepository.searchTasks(dto.getTitle(),
                dto.getDescription(),
                dto.getStatus(),
                dto.getPriority(),
                dto.getFromDueDate(),
                dto.getToDueDate(),
                pageable);

        return new PageDTO(
                CollectionUtils.isEmpty(data.getContent()) ? new ArrayList<>() : taskMapper.toDtos(data.getContent()),
                data.getTotalPages(),
                data.getTotalElements()
        );
    }

    public TaskDTO findById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        return taskMapper.toDto(task);
    }

    public TaskDTO save(TaskDTO dto) {
        Task task = taskMapper.toEntity(dto);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }

    public TaskDTO update(TaskDTO dto) {
        Task existingTask = taskRepository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + dto.getId()));
        existingTask = taskMapper.toEntity(dto);
        Task updatedTask = taskRepository.save(existingTask);
        return taskMapper.toDto(updatedTask);
    }

    public void deleteById(Long id) {
        taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        taskRepository.deleteById(id);
    }
}
