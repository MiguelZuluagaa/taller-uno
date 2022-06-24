package com.co.talleruno.service;

import com.co.talleruno.mapper.BacklogInDtoTOBacklog;
import com.co.talleruno.persistence.entity.BackLog;
import com.co.talleruno.persistence.repository.BackLogRepository;
import com.co.talleruno.service.dto.BacklogInDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BacklogService {

    private final BackLogRepository repository;
    private final BacklogInDtoTOBacklog mapper;

    public BackLog createBacklog(BacklogInDTO backlogInDTO){
        BackLog backlog = mapper.map(backlogInDTO);
        return this.repository.save(backlog);
    }

}
