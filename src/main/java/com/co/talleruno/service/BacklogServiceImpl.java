package com.co.talleruno.service;

import com.co.talleruno.persistence.entity.Backlog;
import com.co.talleruno.persistence.repository.BacklogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BacklogServiceImpl implements BacklogService{

    private final BacklogRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Backlog> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Backlog findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Backlog save(Backlog backlog) {
        return repository.save(backlog);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
