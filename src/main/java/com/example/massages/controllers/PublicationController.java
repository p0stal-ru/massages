package com.example.massages.controllers;

import com.example.massages.controllers.payload.PublicationDTO;
import com.example.massages.controllers.payload.UserDTO;
import com.example.massages.models.Publication;
import com.example.massages.models.User;
import com.example.massages.services.PublicationService;
import com.example.massages.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/users/{userId:\\d+}/post")
public class PublicationController {

    private final UserService userService;

    private final PublicationService publicationService;

    private final MessageSource messageSource;

    @Autowired
    public PublicationController(UserService userService, PublicationService publicationService, MessageSource messageSource) {
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
    public ResponseEntity<List<Publication>> getAllPost() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.publicationService.findAllPosts());
    }

    @PostMapping
    public ResponseEntity<?> CreateNewPost(@PathVariable(name = "userId") int userId,
                                           @Valid @RequestBody PublicationDTO publicationDTO, BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        this.publicationService.createPost(publicationDTO.user(), publicationDTO.title());
        return ResponseEntity.ok().build();
    }



}
