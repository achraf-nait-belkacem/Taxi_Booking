package com.taxi.taxi._backend.dto;

import com.taxi.taxi._backend.entity.StatutCourse;
import jakarta.validation.constraints.NotNull;

public record StatutUpdateRequest(
        @NotNull(message = "Le statut est obligatoire")
        StatutCourse statut
) {
}
