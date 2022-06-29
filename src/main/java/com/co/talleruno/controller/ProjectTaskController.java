package com.co.talleruno.controller;

import com.co.talleruno.helpers.Response;
import com.co.talleruno.helpers.ResponseBuild;
import com.co.talleruno.persistence.entity.ProjectTask;
import com.co.talleruno.service.ProjectTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks/")
@RequiredArgsConstructor
public class ProjectTaskController {

    private final ProjectTaskService projectTaskService;
    private final ResponseBuild build;


    @PostMapping
    public Response save(@Valid @RequestBody ProjectTask projectTask, BindingResult result){
        if (result.hasErrors()){
            return build.failed(formatMessage(result));
        }
        projectTaskService.save(projectTask);
        return build.success(projectTask);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        ProjectTask projectTask = projectTaskService.findById(id);
        projectTaskService.delete(projectTask);
        return build.success(projectTask);
    }

    @GetMapping()
    public List<ProjectTask> index(){
        return projectTaskService.findAll();
    }

    @GetMapping("/{id}")
    public Response findAll(){
        return build.success(projectTaskService.findAll());
    }


    @PutMapping("/{id}")
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
