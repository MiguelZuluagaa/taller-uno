package com.co.talleruno.service.dto;

import com.co.talleruno.persistence.entity.Backlog;
import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.persistence.entity.ProjectTask;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProjectInDTO {
    private String projectName;
    private String projectIdentifier;
    private String descripcion;
    private Date endDate;
    private Backlog backlog;
}
