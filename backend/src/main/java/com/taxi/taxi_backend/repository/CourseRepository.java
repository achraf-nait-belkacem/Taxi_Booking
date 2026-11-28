package com.taxi.taxi_backend.repository;

import com.taxi.taxi_backend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByOrderByDateHeureAsc();
}
