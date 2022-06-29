package com.co.talleruno.service;

import com.co.talleruno.persistence.entity.ProjectTask;

import java.util.List;

public interface ProjectTaskService {
    List<ProjectTask> findAll();
    ProjectTask findById(Long id);
    ProjectTask save(ProjectTask projectTask);
    void delete(ProjectTask projectTask);
}
