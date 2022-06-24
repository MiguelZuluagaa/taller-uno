package com.co.talleruno.mapper;

import com.co.talleruno.persistence.entity.BackLog;
import com.co.talleruno.service.dto.BacklogInDTO;
import org.springframework.stereotype.Component;

@Component
public class BacklogInDtoTOBacklog implements IMapper<BacklogInDTO, BackLog>{

    @Override
    public BackLog map(BacklogInDTO in) {
        BackLog backlog = new BackLog();
        backlog.setProjectIdentifier(in.getProjectIdentifier());
        backlog.setProject(in.getProject());
        backlog.setProjectTask(in.getProjectTask());
        return backlog;
    }
}
