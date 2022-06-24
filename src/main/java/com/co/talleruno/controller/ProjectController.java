package com.co.talleruno.controller;

import com.co.talleruno.helpers.Response;
import com.co.talleruno.helpers.ResponseBuild;
import com.co.talleruno.persistence.entity.Project;
import com.co.talleruno.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/projects/")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ResponseBuild build;


    @PostMapping
    public Response save(@Valid @RequestBody Project project, BindingResult result){
        if(result.hasErrors()){
            return build.failed(result.getAllErrors());
        }
        projectService.save(project);
        return build.success(project);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Project project = projectService.findById(id);
        projectService.delete(project);
        return build.success(project);
    }

    @GetMapping
    public Response findAll(){ return build.success(projectService.findAll()); }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){ return build.success(projectService.findById(id)); }


}
