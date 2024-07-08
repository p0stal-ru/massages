package com.example.massages.controllers;

import com.example.massages.controllers.payload.UserDTO;
import com.example.massages.exceptions.UserExistException;
import com.example.massages.models.User;
import com.example.massages.services.PublicationService;
import com.example.massages.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private final UserService userService;
    private final PublicationService publicationService;

    @Autowired
    public UsersController(UserService userService, PublicationService publicationService) {
        this.userService = userService;
        this.publicationService = publicationService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.userService.findAll());
    }

//    @GetMapping
//    public List<User> findAll() {
//        return userService.findAll();
//    }

    @PostMapping
    public ResponseEntity<?> CreateNewUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult,
                                           UriComponentsBuilder uriComponentsBuilder) throws BindException {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new UserExistException(errorMsg.toString());
        } else {
            User user = this.userService.createUser(userDTO.userName(), userDTO.password());
            return ResponseEntity.created(uriComponentsBuilder
                            .replacePath("api/users/{userId}")
                    .build(Map.of("userId", user.getId())))
                    .body(user);
        }

//        return ResponseEntity.ok().build();
    }

}
