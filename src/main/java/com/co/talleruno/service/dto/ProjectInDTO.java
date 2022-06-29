package com.co.talleruno.service.dto;

import com.co.talleruno.persistence.entity.Backlog;
import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.persistence.entity.ProjectTask;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectInDTO {
    private String projectName;
    private String projectIdentifier;
    private String descripcion;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Backlog backlog;
}
