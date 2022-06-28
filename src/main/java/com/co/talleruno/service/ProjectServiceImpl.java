package com.co.talleruno.service;

import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.persistence.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Project save(Project project) {
        projectRepository.save(project);
        return project;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Project project) {
        projectRepository.delete(project);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }
}
