package com.taxi.taxi_backend.controller;

import com.taxi.taxi_backend.dto.CourseRequest;
import com.taxi.taxi_backend.dto.CourseResponse;
import com.taxi.taxi_backend.dto.PrixUpdateRequest;
import com.taxi.taxi_backend.dto.StatutUpdateRequest;
import com.taxi.taxi_backend.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponse> creer(@Valid @RequestBody CourseRequest request) {
        CourseResponse creee = courseService.creer(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(creee.id())
                .toUri();
        return ResponseEntity.created(location).body(creee);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> lister() {
        return ResponseEntity.ok(courseService.lister());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> detail(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.trouverParId(id));
    }

    @PutMapping("/{id}/statut")
    public ResponseEntity<CourseResponse> changerStatut(@PathVariable Long id,
                                                        @Valid @RequestBody StatutUpdateRequest request) {
        return ResponseEntity.ok(courseService.changerStatut(id, request.statut()));
    }

    @PatchMapping("/{id}/prix")
    public ResponseEntity<CourseResponse> fixerPrix(@PathVariable Long id,
                                                    @Valid @RequestBody PrixUpdateRequest request) {
        return ResponseEntity.ok(courseService.fixerPrix(id, request.prix()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        courseService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
