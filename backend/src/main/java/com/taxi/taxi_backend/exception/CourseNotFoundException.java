package com.taxi.taxi_backend.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long id) {
        super("Course introuvable avec l'id " + id);
    }
}
