package com.example.massages.controllers.payload;

import com.example.massages.models.User;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDateTime;

public record PublicationDTO(User user, String title) {
}
