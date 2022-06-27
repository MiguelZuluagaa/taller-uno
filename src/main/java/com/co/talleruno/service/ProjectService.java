package com.co.talleruno.service;

import com.co.talleruno.persistence.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    Project findById(Long id);
    Project save(Project project);

    void delete(Long id);


}
