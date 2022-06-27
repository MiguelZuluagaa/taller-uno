package com.co.talleruno.controller;

import com.co.talleruno.persistence.entity.ProjectTask;
import com.co.talleruno.service.ProjectTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/")
@RequiredArgsConstructor
public class ProjectTaskController {

    private final ProjectTaskService projectTaskService;

    @GetMapping()
    public List<ProjectTask> index(){
        return projectTaskService.findAll();
    }

    @GetMapping("/{id}")
    public ProjectTask show(@PathVariable Long id){
        return projectTaskService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectTask create(@RequestBody ProjectTask projectTask){
        return projectTaskService.save(projectTask);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectTask update(@RequestBody ProjectTask projectTask, @PathVariable Long id){
        ProjectTask projectTaskActual = projectTaskService.findById(id);
        projectTaskActual.setName(projectTask.getName());
        projectTaskActual.setSummary(projectTask.getSummary());
        projectTaskActual.setAcceptanceCriteria(projectTask.getAcceptanceCriteria());
        projectTaskActual.setProjectStatus(projectTask.getProjectStatus());
        projectTaskActual.setPriority(projectTask.getPriority());
        projectTaskActual.setHours(projectTask.getHours());
        projectTaskActual.setStartDate(projectTask.getStartDate());
        projectTaskActual.setEndDate(projectTask.getEndDate());
        projectTaskActual.setProjectIdentifier(projectTask.getProjectIdentifier());
        projectTaskActual.setBacklog(projectTask.getBacklog());

        return projectTaskService.save(projectTaskActual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        projectTaskService.delete(id);
    }
}
