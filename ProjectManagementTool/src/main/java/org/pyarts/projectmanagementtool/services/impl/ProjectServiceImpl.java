package org.pyarts.projectmanagementtool.services.impl;

import org.pyarts.projectmanagementtool.domain.Backlog;
import org.pyarts.projectmanagementtool.domain.Project;
import org.pyarts.projectmanagementtool.exceptions.ProjectIdException;
import org.pyarts.projectmanagementtool.repositories.BacklogRepository;
import org.pyarts.projectmanagementtool.repositories.ProjectRepository;
import org.pyarts.projectmanagementtool.services.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final BacklogRepository backlogRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, BacklogRepository backlogRepository) {
        this.projectRepository = projectRepository;
        this.backlogRepository = backlogRepository;
    }


    @Override
    public Project saveOrUpdateProject(Project project) {
        try {
            String projectIdentifier = project.getProjectIdentifier().toUpperCase();
            project.setProjectIdentifier(projectIdentifier);
            if (project.getId() == null) {
                Backlog backlog = new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(projectIdentifier);
            } else {
                project.setBacklog(backlogRepository.findBacklogByProjectIdentifier(projectIdentifier));
            }
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID '" +
                    project.getProjectIdentifier() + "' already Used");
        }

    }

    @Override
    public Project findProjectByIdentifier(String identifier) {
        Project project = projectRepository.findByProjectIdentifier(identifier.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Project ID '" +
                    identifier + "' does not exists");
        }
        return project;
    }

    @Override
    public List<Project> findAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProjectByIdentifier(String identifier) {

        Project project = projectRepository.findByProjectIdentifier(identifier.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Project ID '" +
                    identifier + "' does not exists");
        }
        projectRepository.delete(project);
    }
}
