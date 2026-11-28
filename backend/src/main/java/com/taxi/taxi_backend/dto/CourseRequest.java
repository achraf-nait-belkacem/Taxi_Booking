package com.taxi.taxi_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CourseRequest(

        @NotNull(message = "La date et l'heure sont obligatoires")
        LocalDateTime dateHeure,

        @NotBlank(message = "Le lieu de départ est obligatoire")
        String depart,

        @NotBlank(message = "La destination est obligatoire")
        String destination,

        @NotBlank(message = "Le nom du client est obligatoire")
        String clientNom,

        @NotBlank(message = "Le téléphone du client est obligatoire")
        String clientTelephone
) {
}
