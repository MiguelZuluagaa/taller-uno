package com.co.talleruno.persistence.repository;

import com.co.talleruno.persistence.entity.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {
}
