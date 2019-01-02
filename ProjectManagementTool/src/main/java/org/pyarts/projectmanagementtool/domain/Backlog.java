package org.pyarts.projectmanagementtool.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Backlog extends BaseEntity {

    private Integer PTSequence = 0;
    private String projectIdentifier;

    // one-to-one with project


    // one-to-many project-tasks
}
