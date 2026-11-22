package com.taxi.taxi._backend.repository;

import com.taxi.taxi._backend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByOrderByDateHeureAsc();
}
