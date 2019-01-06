package org.pyarts.projectmanagementtool.services.impl;

import org.pyarts.projectmanagementtool.domain.Backlog;
import org.pyarts.projectmanagementtool.domain.ProjectTask;
import org.pyarts.projectmanagementtool.repositories.BacklogRepository;
import org.pyarts.projectmanagementtool.repositories.ProjectTaskRepository;
import org.pyarts.projectmanagementtool.services.ProjectTaskService;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {

    private final ProjectTaskRepository projectTaskRepository;
    private final BacklogRepository backlogRepository;

    public ProjectTaskServiceImpl(ProjectTaskRepository projectTaskRepository, BacklogRepository backlogRepository) {
        this.projectTaskRepository = projectTaskRepository;
        this.backlogRepository = backlogRepository;
    }


    @Override
    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
        Backlog backlog = backlogRepository.findBacklogByProjectIdentifier(projectIdentifier);
        projectTask.setBacklog(backlog);
        Integer backlogSequence = backlog.getPTSequence();
        backlogSequence += 1;
        backlog.setPTSequence(backlogSequence);
        projectTask.setProjectSequence(projectIdentifier + "-" + backlogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);
        if (projectTask.getPriority() == null || projectTask.getPriority() == 0) {
            projectTask.setPriority(3);
        }
        if (projectTask.getStatus() == null || projectTask.getStatus().equals("")) {
            projectTask.setStatus("TO_DO");
        }
        return projectTaskRepository.save(projectTask);
    }
}
