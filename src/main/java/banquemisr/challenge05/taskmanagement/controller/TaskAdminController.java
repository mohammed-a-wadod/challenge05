package banquemisr.challenge05.taskmanagement.controller;

import banquemisr.challenge05.taskmanagement.models.dtos.TaskDTO;
import banquemisr.challenge05.taskmanagement.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks/admin")
@RequiredArgsConstructor
public class TaskAdminController {

    private final TaskService taskService;

    @GetMapping("/all-tasks")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }
}
