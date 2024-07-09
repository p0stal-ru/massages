package com.example.massages.controllers;

import com.example.massages.dto.UserDto;
import com.example.massages.exceptions.UserNotFoundException;
import com.example.massages.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserDto> findUser(@RequestParam(name = "userId") Long userId) {

        UserDto user = null;

        try {
            user = userService.findUserById(userId);

            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
