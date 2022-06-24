package com.co.talleruno.persistence.entity;


import lombok.*;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",updatable = false,nullable = false,unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "summary")
    private String summary;

    @Column(name = "acceptanceCriteria")
    private String acceptanceCriteria;

    @Column(name = "status")
    private String status;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "hours")
    private Double hours;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "ndDate")
    private Date endDate;

    @Column(name = "projectIdentifier")
    private String projectIdentifier;

    @ManyToOne()
    @JoinColumn(name = "backLog_id")
    private BackLog backLog;

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
