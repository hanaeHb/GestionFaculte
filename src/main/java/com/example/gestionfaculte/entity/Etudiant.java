package com.example.gestionfaculte.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nom;
    private String prenom;
    private String cne;
    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;
}
