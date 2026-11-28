package com.taxi.taxi._backend.service;

import com.taxi.taxi._backend.dto.CourseRequest;
import com.taxi.taxi._backend.dto.CourseResponse;
import com.taxi.taxi._backend.entity.Course;
import com.taxi.taxi._backend.entity.StatutCourse;
import com.taxi.taxi._backend.exception.CourseNotFoundException;
import com.taxi.taxi._backend.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional
    public CourseResponse creer(CourseRequest request) {
        Course course = Course.builder()
                .dateHeure(request.dateHeure())
                .depart(request.depart())
                .destination(request.destination())
                .clientNom(request.clientNom())
                .clientTelephone(request.clientTelephone())
                .statut(StatutCourse.EN_ATTENTE)
                .build();

        Course sauvegardee = courseRepository.save(course);
        return CourseResponse.fromEntity(sauvegardee);
    }

    @Transactional(readOnly = true)
    public List<CourseResponse> lister() {
        return courseRepository.findAllByOrderByDateHeureAsc()
                .stream()
                .map(CourseResponse::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public CourseResponse trouverParId(Long id) {
        return CourseResponse.fromEntity(chargerOuEchouer(id));
    }

    @Transactional
    public CourseResponse changerStatut(Long id, StatutCourse nouveauStatut) {
        Course course = chargerOuEchouer(id);
        course.setStatut(nouveauStatut);
        return CourseResponse.fromEntity(course);
    }

    @Transactional
    public CourseResponse fixerPrix(Long id, BigDecimal prix) {
        Course course = chargerOuEchouer(id);
        course.setPrix(prix);
        return CourseResponse.fromEntity(course);
    }

    @Transactional
    public void supprimer(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException(id);
        }
        courseRepository.deleteById(id);
    }

    private Course chargerOuEchouer(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }
}
