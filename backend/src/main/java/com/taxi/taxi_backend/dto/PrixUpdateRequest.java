package com.taxi.taxi_backend.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PrixUpdateRequest(
        @NotNull(message = "Le prix est obligatoire")
        @Positive(message = "Le prix doit être strictement positif")
        @Digits(integer = 8, fraction = 2, message = "Le prix doit avoir au plus 2 décimales")
        BigDecimal prix
) {
}
