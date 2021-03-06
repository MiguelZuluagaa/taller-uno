package com.co.talleruno.persistence.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="projectTasks")
public class ProjectTask {

    @Id
    //@NotEmpty(message = "El id no puede estar vacio")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",updatable = false,nullable = false,unique = true)
    private Long id;

    @NotEmpty(message = "EL nombre no puede estar vacio")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "El resumen no puede estar vacio")
    @Column(name = "summary")
    private String summary;

    @Column(name = "acceptance_criteria")
    private String acceptanceCriteria;

    @Column(name = "status")
    private ProjectStatus projectStatus;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "hours")
    private Double hours;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "project_identifier")
    private String projectIdentifier;

    @ManyToOne()
    @JoinColumn(name = "backlog_id")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTask that = (ProjectTask) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
