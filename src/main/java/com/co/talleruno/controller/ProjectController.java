package com.co.talleruno.controller;

import com.co.talleruno.helpers.Response;
import com.co.talleruno.helpers.ResponseBuild;
import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects/")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ResponseBuild build;

    @GetMapping()
    public List<Project> index(){
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project show(@PathVariable Long id){
        return projectService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody Project project){
        return projectService.save(project);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Project update(@RequestBody Project project, @PathVariable Long id){
        Project projectActual = projectService.findById(id);
        projectActual.setProjectName(project.getProjectName());
        projectActual.setProjectIdentifier(project.getProjectIdentifier());
        projectActual.setDescripcion(project.getDescripcion());
        projectActual.setStartDate(project.getStartDate());
        projectActual.setEndDate(project.getEndDate());
        projectActual.setBacklog(project.getBacklog());

        return projectService.save(projectActual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        projectService.delete(id);
    }

}
