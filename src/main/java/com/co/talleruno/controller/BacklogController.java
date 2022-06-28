package com.co.talleruno.controller;

import com.co.talleruno.helpers.Response;
import com.co.talleruno.helpers.ResponseBuild;
import com.co.talleruno.persistence.entity.Backlog;
import com.co.talleruno.service.BacklogService;
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
@RequestMapping("/backlogs/")
@RequiredArgsConstructor
public class BacklogController {

    private final BacklogService backlogService;
    private final ResponseBuild build;

    @PostMapping()
    public Response save(@Valid @RequestBody Backlog backlog, BindingResult result){
        if (result.hasErrors()){
            return build.failed(formatMessage(result));
        }
        backlogService.save(backlog);
        return build.success(backlog);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Backlog backlog = backlogService.findById(id);
        backlogService.delete(backlog);
        return build.success(backlog);
    }

    @GetMapping()
    public Response findAll(){
        return build.success(backlogService.findAll());
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        return build.success(backlogService.findById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Backlog update(@RequestBody Backlog backlog, @PathVariable Long id){
        Backlog backlogActual = backlogService.findById(id);
        backlogActual.setProjectIdentifier(backlog.getProjectIdentifier());
        backlogActual.setProject(backlog.getProject());
        backlogActual.setProjectTask(backlog.getProjectTask());

        return backlogService.save(backlogActual);
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
