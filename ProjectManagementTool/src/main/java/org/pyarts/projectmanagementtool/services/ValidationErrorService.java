package org.pyarts.projectmanagementtool.services;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface ValidationErrorService {

    ResponseEntity<?> validationError(BindingResult result);

}
