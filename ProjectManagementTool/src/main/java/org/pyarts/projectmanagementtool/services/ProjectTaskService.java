package org.pyarts.projectmanagementtool.services;

import org.pyarts.projectmanagementtool.domain.ProjectTask;

public interface ProjectTaskService  {
    ProjectTask addProjectTask(String projectIdentifier,ProjectTask projectTask);
}
