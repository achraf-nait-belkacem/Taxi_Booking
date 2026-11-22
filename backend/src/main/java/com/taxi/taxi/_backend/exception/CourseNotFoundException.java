package com.taxi.taxi._backend.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long id) {
        super("Course introuvable avec l'id " + id);
    }
}
