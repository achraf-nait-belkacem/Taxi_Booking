package com.taxi.taxi_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User client;

    @ManyToOne
    @JoinColumn(name = "chauffeur_id")
    private User chauffeur;

    @Column(nullable = false)
    private String depart;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private LocalDateTime dateHeure;

    @Enumerated(EnumType.STRING)
    private StatutBooking statut;

    private Double prixEstime;
}