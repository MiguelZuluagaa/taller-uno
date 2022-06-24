package com.co.talleruno.service;

import com.co.talleruno.persistence.entity.Project;

import java.util.List;

public interface ProjectService {

    void save(Project project);
    void delete(Project project);
    List<Project> findAll();
    Project findById(Long id);
}
