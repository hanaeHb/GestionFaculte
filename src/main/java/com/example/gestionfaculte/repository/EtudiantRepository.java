package com.example.gestionfaculte.repository;

import com.example.gestionfaculte.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
}
