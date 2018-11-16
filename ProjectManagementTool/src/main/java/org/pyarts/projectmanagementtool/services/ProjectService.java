package org.pyarts.projectmanagementtool.services;

import org.pyarts.projectmanagementtool.domain.Project;

public interface ProjectService {

    Project saveOrUpdateProject(Project project);
}
