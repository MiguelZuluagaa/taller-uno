package com.co.talleruno.controller;

import com.co.talleruno.persistence.entity.Backlog;
import com.co.talleruno.service.BacklogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backlogs/")
@RequiredArgsConstructor
public class BacklogController {

    private final BacklogService backlogService;

    @GetMapping()
    public List<Backlog> index(){
        return backlogService.findAll();
    }

    @GetMapping("/{id}")
    public Backlog show(@PathVariable Long id){
        return backlogService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Backlog create(@RequestBody Backlog backlog){
        return backlogService.save(backlog);
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        backlogService.delete(id);
    }
}
