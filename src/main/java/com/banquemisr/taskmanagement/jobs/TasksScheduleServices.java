package com.banquemisr.taskmanagement.jobs;

import com.banquemisr.taskmanagement.models.entites.Task;
import com.banquemisr.taskmanagement.models.enums.TaskStatusEnum;
import com.banquemisr.taskmanagement.repository.TaskRepository;
import com.banquemisr.taskmanagement.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TasksScheduleServices {

    private final TaskRepository taskRepository;
    private final EmailService emailService;

    //TODO we need to change this fixedRate to be cron expression
    @Scheduled(fixedRate = 60000) // every one minute
    public void performTask() {
        System.out.println("Task performed every 1 minute" + LocalDateTime.now());
        LocalDate today = LocalDate.now();
        List<Task> list = taskRepository.findByStatusInAndDueDateLessThanEqual(
                Arrays.asList(TaskStatusEnum.TODO, TaskStatusEnum.IN_PROGRESS),
                today.atTime(LocalTime.MAX)
        );
        list.forEach(task -> {
            System.out.println(task.toString());
            try {
                emailService.sendEmail(task);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
