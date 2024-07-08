package com.example.massages.controllers.payload;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record UserDTO(
        @NotNull
        @Size(min = 3, max = 100, message = "Имя должно быть больше 3 символов")
        String userName,
        @NotNull
        @Size(max = 100)
        String password
) {

}
