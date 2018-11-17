package org.pyarts.projectmanagementtool.web;

import org.pyarts.projectmanagementtool.domain.Project;
import org.pyarts.projectmanagementtool.services.ProjectService;
import org.pyarts.projectmanagementtool.services.ValidationErrorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;
    private final ValidationErrorService validationErrorService;

    public ProjectController(ProjectService projectService,
                             ValidationErrorService validationErrorService) {
        this.projectService = projectService;
        this.validationErrorService = validationErrorService;
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,
                                              BindingResult result) {
        ResponseEntity<?> error = validationErrorService.validationError(result);
        if (error != null) return error;
        return new ResponseEntity<>(projectService.saveOrUpdateProject(project),
                HttpStatus.CREATED);
    }

    @GetMapping("/{projectIdentifier}")
    public ResponseEntity<?> getProjectByIdentifier(@PathVariable("projectIdentifier")
                                                            String projectIdentifier) {
        return new ResponseEntity<>(projectService.findProjectByIdentifier(projectIdentifier),
                HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Project> findAllProjects() {
        return projectService.findAllProject();
    }

    @DeleteMapping("/{projectIdentifier}")
    public ResponseEntity<?> deleteProjectByIdentifier(@PathVariable("projectIdentifier")
                                                               String projectIdentifier) {
        projectService.deleteProjectByIdentifier(projectIdentifier);

        return new ResponseEntity<>("Project ID '" + projectIdentifier + "' was deleted",
                HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateNewProject(@Valid @RequestBody Project project,
                                              BindingResult result) {
        if (project.getId() == null) {
            return new ResponseEntity<>("Project id is required for update",
                    HttpStatus.CONFLICT);
        }
        ResponseEntity<?> error = validationErrorService.validationError(result);
        if (error != null) return error;
        return new ResponseEntity<>(projectService.saveOrUpdateProject(project),
                HttpStatus.CREATED);
    }
}
