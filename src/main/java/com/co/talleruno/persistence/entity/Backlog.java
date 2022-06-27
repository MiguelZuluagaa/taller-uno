package com.co.talleruno.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name ="backlogs")
public class Backlog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",updatable = false,nullable = false,unique = true)
    private Long id;

    @Column(name = "project_identifier")
    private String projectIdentifier;

    @JoinColumn(name = "project")
    @OneToOne(fetch = FetchType.LAZY)
    private Project project;

    @JoinColumn(name = "projectTask")
    @OneToMany()
    private List<ProjectTask> projectTask;

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backlog backlog = (Backlog) o;
        return Objects.equals(id, backlog.id);
    }*/

/*    @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/
}