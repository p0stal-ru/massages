package com.example.massages.controllers;

import com.example.massages.dto.PostDto;
import com.example.massages.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/post")
public class PostController {

    private final PostService postService;

    private static final String POST_URI = "api/post/";

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostDto dto) {

        Long postId = null;

        try {

            return ResponseEntity.created(new URI(POST_URI + postService.createPost(dto))).build();

        } catch (IllegalArgumentException | URISyntaxException e) {

            return ResponseEntity.badRequest().build();
        }

    }

}
