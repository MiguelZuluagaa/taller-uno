package com.co.talleruno.service.dto;

import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.persistence.entity.ProjectTask;
import lombok.Data;

import java.util.List;

@Data
public class BacklogInDTO {
    private String projectIdentifier;
    private Project project;
    private List<ProjectTask> projectTask;
}
