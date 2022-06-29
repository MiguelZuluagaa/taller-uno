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

    private final BacklogRepository backlogRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Backlog> findAll() {
        return backlogRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Backlog findById(Long id) {
        return backlogRepository.findById(id).orElse(null);
    }

    @Override
    public Backlog save(Backlog backlog) {
        backlogRepository.save(backlog);
        return backlog;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Backlog backlog) {
        backlogRepository.delete(backlog);
    }


}
