package org.pyarts.projectmanagementtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Project extends BaseEntity {

    @NotBlank(message = "Project Name is required")
    private String projectName;
    @NotBlank(message = "Project Identifier is required")
    @Size(min = 4,max = 5,message = "Please use 4 to 5 characters only")
    @Column(updatable = false,unique = true)
    private String projectIdentifier;
    @NotBlank(message = "Project Description is required")
    @Column(columnDefinition = "text")
    private String description;
    @JsonFormat(pattern = "dd-MMM-yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern = "dd-MMM-yyyy")
    private LocalDate endDate;
}
