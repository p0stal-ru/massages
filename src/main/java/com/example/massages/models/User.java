package com.example.massages.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 30 characters")
    @Column(name = "user_name", unique = true)
    private String userName;

//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name", unique = true)
//    private String lastName;
//
//    @Column(name = "age")
//    private int age;
//
//    @Email
//    @Column(name = "email")
//    private String email;

    @NotEmpty(message = "Пароль не должен быть пустым")
    @Column(name = "password", length = 100)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<Publication> publications = new ArrayList<>();

//    @Column(name = "date_of_birth")
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    private Date dateOfBirth;

//    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    private LocalDateTime createAt;

    public User(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}




