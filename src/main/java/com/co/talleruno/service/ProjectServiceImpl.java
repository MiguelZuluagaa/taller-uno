package com.co.talleruno.service;

import com.co.talleruno.mapper.ProjectInDtoToProject;
import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.persistence.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Project findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Project save(Project project) {
        return repository.save(project);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
