package com.example.massages.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_t")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer age;

    @Email
    @Column(unique = true)
    private String email;

    @Column(length = 100)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @Column
    private LocalDateTime createdAt;


    @PrePersist
    public void addCreationDate() {
        createdAt = LocalDateTime.now();
    }

}




