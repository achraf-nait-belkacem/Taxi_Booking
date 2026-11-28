package com.taxi.taxi_backend.dto;

import com.taxi.taxi_backend.entity.Course;
import com.taxi.taxi_backend.entity.StatutCourse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CourseResponse(
        Long id,
        LocalDateTime dateHeure,
        String depart,
        String destination,
        BigDecimal prix,
        StatutCourse statut,
        String clientNom,
        String clientTelephone
) {
    public static CourseResponse fromEntity(Course course) {
        return new CourseResponse(
                course.getId(),
                course.getDateHeure(),
                course.getDepart(),
                course.getDestination(),
                course.getPrix(),
                course.getStatut(),
                course.getClientNom(),
                course.getClientTelephone()
        );
    }
}
