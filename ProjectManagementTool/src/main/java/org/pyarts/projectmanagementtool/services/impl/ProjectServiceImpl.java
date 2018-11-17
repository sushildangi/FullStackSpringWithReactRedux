package org.pyarts.projectmanagementtool.services.impl;

import org.pyarts.projectmanagementtool.domain.Project;
import org.pyarts.projectmanagementtool.exceptions.ProjectIdException;
import org.pyarts.projectmanagementtool.repositories.ProjectRepository;
import org.pyarts.projectmanagementtool.services.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID '" +
                    project.getProjectIdentifier() + "' already Used");
        }

    }
}
