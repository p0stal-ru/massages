package com.example.massages.dto;

import com.example.massages.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long id;

    private String title;

    private Integer likes;

    private Long userId;

    private Date createdAt;

    private List<CommentDto> comments = new ArrayList<>();

}

