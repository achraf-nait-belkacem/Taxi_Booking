package com.taxi.taxi_backend.dto;

import com.taxi.taxi_backend.entity.StatutCourse;
import jakarta.validation.constraints.NotNull;

public record StatutUpdateRequest(
        @NotNull(message = "Le statut est obligatoire")
        StatutCourse statut
) {
}
