package org.pyarts.projectmanagementtool.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectIdExceptionResponse {
    private String projectIdentifier;
}
