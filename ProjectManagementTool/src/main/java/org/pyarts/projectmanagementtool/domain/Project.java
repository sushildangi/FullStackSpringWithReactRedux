package org.pyarts.projectmanagementtool.domain;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Project extends BaseEntity {
    private String projectName;
    private String projectIdentifier;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
