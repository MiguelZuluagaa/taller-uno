package com.co.talleruno.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",updatable = false,nullable = false,unique = true)
    private Long id;

    @Column(name = "projectName")
    private String projectName;

    @Column(name = "projectIdentifier")
    private String projectIdentifier;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private Date endDate;

    @JoinColumn(name = "backlog")
    @OneToOne(fetch = FetchType.LAZY)
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
