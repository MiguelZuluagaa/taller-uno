package com.co.talleruno.persistence.repository;

import com.co.talleruno.persistence.entity.BackLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BackLogRepository extends JpaRepository<BackLog, Long> {
}
