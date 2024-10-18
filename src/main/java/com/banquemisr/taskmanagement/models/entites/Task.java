package com.banquemisr.taskmanagement.models.entites;

import com.banquemisr.taskmanagement.models.enums.TaskPriorityEnum;
import com.banquemisr.taskmanagement.models.enums.TaskStatusEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TASKS")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;

    @Column(name = "PRIORITY")
    @Enumerated(EnumType.STRING)
    private TaskPriorityEnum priority;

    @Column(name = "DUE_DATE")
    private LocalDate dueDate;
}
