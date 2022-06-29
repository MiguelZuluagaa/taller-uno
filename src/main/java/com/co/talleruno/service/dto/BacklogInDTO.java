package com.co.talleruno.service.dto;

import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.persistence.entity.ProjectTask;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BacklogInDTO {
    private String projectIdentifier;
    private Project project;
    private List<ProjectTask> projectTask;
}
