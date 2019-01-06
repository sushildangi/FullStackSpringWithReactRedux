package org.pyarts.projectmanagementtool.web;

import org.pyarts.projectmanagementtool.domain.ProjectTask;
import org.pyarts.projectmanagementtool.services.ProjectTaskService;
import org.pyarts.projectmanagementtool.services.ValidationErrorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/backlog")
@CrossOrigin
public class BacklogController {

    private final ProjectTaskService projectTaskService;
    private final ValidationErrorService validationErrorService;

    public BacklogController(ProjectTaskService projectTaskService,
                             ValidationErrorService validationErrorService) {
        this.projectTaskService = projectTaskService;
        this.validationErrorService = validationErrorService;
    }

    @PostMapping("/{backlogId}")
    public ResponseEntity<?> addPTToBacklog(@Valid @RequestBody ProjectTask projectTask,
                                            BindingResult result,
                                            @PathVariable("backlogId") String backlogId) {
        ResponseEntity<?> error = validationErrorService.validationError(result);
        if (error != null) return error;

        return new ResponseEntity<>(projectTaskService.addProjectTask(backlogId, projectTask), HttpStatus.CREATED);
    }
}
