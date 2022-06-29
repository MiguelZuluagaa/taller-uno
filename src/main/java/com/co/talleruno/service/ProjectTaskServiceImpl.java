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

    private final ProjectTaskRepository projectTaskRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectTask> findAll() {
        return projectTaskRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectTask findById(Long id) {
        return projectTaskRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProjectTask save(ProjectTask projectTask) {
        projectTaskRepository.save(projectTask);
        return projectTask;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ProjectTask projectTask) {
        projectTaskRepository.delete(projectTask);
    }


}
