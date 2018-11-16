package org.pyarts.projectmanagementtool.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
public class Project extends BaseEntity {
    private String projectName;
    private String projectIdentifier;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
