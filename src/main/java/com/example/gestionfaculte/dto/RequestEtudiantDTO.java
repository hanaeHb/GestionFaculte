package com.example.gestionfaculte.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class RequestEtudiantDTO {
    private String nom;
    private String prenom;
    private String cne;
    private Integer filiere_id;
}
