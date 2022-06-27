package com.co.talleruno.service;

import com.co.talleruno.persistence.entity.ProjectTask;
import com.co.talleruno.persistence.repository.ProjectTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProjectTaskServiceImpl implements ProjectTaskService{

    private final ProjectTaskRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectTask> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectTask findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ProjectTask save(ProjectTask projectTask) {
        return repository.save(projectTask);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
