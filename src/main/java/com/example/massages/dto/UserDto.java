package com.example.massages.dto;

import com.example.massages.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotEmpty(message = "Id не должен быть пустым")
    private Long id;

    private String userName;

    @Size(min = 2, max = 100, message = "Name should be between 2 and 30 characters")
    private String firstName;

    @Size(min = 2, max = 100, message = "Name should be between 2 and 30 characters")
    private String lastName;

    @Min(value = 0, message = "Age should be greater than 0")
    private Integer age;

    @Email
    private String email;

    private LocalDateTime createdAt;

    public UserDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
    }
}
