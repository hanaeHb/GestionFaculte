package com.example.gestionfaculte.mappers;

import com.example.gestionfaculte.dto.RequestEtudiantDTO;
import com.example.gestionfaculte.dto.ResponceEtudiantDTO;
import com.example.gestionfaculte.entity.Etudiant;
import com.example.gestionfaculte.entity.Filiere;
import com.example.gestionfaculte.repository.FiliereRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EtudiantMapper {

    public Etudiant DTO_TO_ENTITY(RequestEtudiantDTO dto, FiliereRepository filiereRepository) {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(dto.getNom());
        etudiant.setPrenom(dto.getPrenom());
        etudiant.setCne(dto.getCne());

        if(dto.getFiliere_id() != null) {
            Filiere filiere = filiereRepository.findById(dto.getFiliere_id())
                    .orElseThrow(() -> new RuntimeException("Filiere introuvable"));
            etudiant.setFiliere(filiere);
        }

        return etudiant;
    }


    public ResponceEtudiantDTO ENTITY_TO_DTO(Etudiant etudiant) {
        ResponceEtudiantDTO dto = new ResponceEtudiantDTO();
        dto.setId(etudiant.getId());
        dto.setNom(etudiant.getNom());
        dto.setPrenom(etudiant.getPrenom());
        dto.setCne(etudiant.getCne());
        dto.setFiliereCode(etudiant.getFiliere() != null ? etudiant.getFiliere().getCode() : null);
        return dto;
    }

}
