package com.example.massages.controllers;


import com.example.massages.controllers.payload.UserDTO;
import com.example.massages.exceptions.UserExistException;
import com.example.massages.models.User;
import com.example.massages.services.PublicationService;
import com.example.massages.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
@RequestMapping("api/users/{userId:\\d+}")
public class UserController {

    private final UserService userService;

    private final PublicationService publicationService;

    private final MessageSource messageSource;

    @Autowired
    public UserController(UserService userService, PublicationService publicationService, MessageSource messageSource) {
        this.userService = userService;
        this.publicationService = publicationService;
        this.messageSource = messageSource;
    }

    @ModelAttribute("user")
    public User getUser(@PathVariable(name = "userId") int userId) {
        return this.userService.findUserById(userId).
                orElseThrow(() -> new NoSuchElementException("Пользователь не найден"));
    }

    @GetMapping
    public User findUser(@ModelAttribute("user") User user) {
        return user;
    }

    @PatchMapping
    public ResponseEntity<?> updateUser(@PathVariable(name = "userId") int userId,
                                        @Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            this.userService.updateUser(userId, userDTO.userName(), userDTO.password());
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId) {
        this.userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ProblemDetail> handleNoSuchElementException(NoSuchElementException exception, Locale locale) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                        Objects.requireNonNull(this.messageSource.getMessage(exception.getMessage(), new Object[0],
                                exception.getMessage(), locale))));
    }
}
