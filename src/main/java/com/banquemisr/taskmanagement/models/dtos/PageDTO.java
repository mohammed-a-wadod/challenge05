package com.banquemisr.taskmanagement.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageDTO {
    private List<?> content;
    private Integer  totalPages;
    private Long  totalElements;
}
