package com.co.talleruno.controller;

import com.co.talleruno.helpers.Response;
import com.co.talleruno.helpers.ResponseBuild;
import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projects/")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ResponseBuild build;

    @PostMapping()
    public Response save(@Valid @RequestBody Project project, BindingResult result){
        if (result.hasErrors()){
            return build.failed(formatMessage(result));
        }
        projectService.save(project);
        return build.success(project);
    }

    @GetMapping()
    public List<Project> index(){
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project show(@PathVariable Long id){
        return projectService.findById(id);
    }



    @PutMapping("/{id}")
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
    public Response delete(@PathVariable("id") Long id){
        Project project = projectService.findById(id);
        projectService.delete(project);
        return build.success(project);
    }

    private List<Map<String, String>> formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
        return errors;
    }

}
