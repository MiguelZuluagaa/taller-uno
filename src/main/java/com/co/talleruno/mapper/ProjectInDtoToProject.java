package com.co.talleruno.mapper;

import com.co.talleruno.persistence.entity.Backlog;
import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.service.dto.ProjectInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class ProjectInDtoToProject implements IMapper<ProjectInDTO, Project>{
    @Override
    public Project map(ProjectInDTO in) {
        Project project = new Project();
        project.setProjectName(in.getProjectName());
        project.setProjectIdentifier(in.getProjectIdentifier());
        project.setDescripcion(in.getDescripcion());
        project.setStartDate(LocalDateTime.now());
        project.setEndDate(in.getEndDate());
        project.setBacklog(in.getBacklog());
        return project;
    }
}
