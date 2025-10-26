package com.example.gestionfaculte.service;

import com.example.gestionfaculte.dto.RequestEtudiantDTO;
import com.example.gestionfaculte.dto.ResponceEtudiantDTO;
import com.example.gestionfaculte.dto.ResponceFiliereDto;
import com.example.gestionfaculte.entity.Etudiant;
import com.example.gestionfaculte.entity.Filiere;
import com.example.gestionfaculte.mappers.EtudiantMapper;
import com.example.gestionfaculte.repository.EtudiantRepository;
import com.example.gestionfaculte.repository.FiliereRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    private EtudiantRepository etudiantRepository;
    private EtudiantMapper etudiantMapper;
    private FiliereRepository filiereRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository, EtudiantMapper etudiantMapper, FiliereRepository filiereRepository) {
        this.etudiantMapper = etudiantMapper;
        this.etudiantRepository = etudiantRepository;
        this.filiereRepository = filiereRepository;
    }
    @Override
    public ResponceEtudiantDTO AddEtudiant(RequestEtudiantDTO requestEtudiantDTO) {

        Etudiant etudiant = etudiantMapper.DTO_TO_ENTITY(requestEtudiantDTO, filiereRepository);
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        return etudiantMapper.ENTITY_TO_DTO(savedEtudiant);
    }

    @Override
    public List<ResponceEtudiantDTO> GETALLEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        List<ResponceEtudiantDTO> etudiantDtos = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            etudiantDtos.add(etudiantMapper.ENTITY_TO_DTO(etudiant));
        }
        return etudiantDtos;
    }

    @Override
    public ResponceEtudiantDTO GETEtudiantById(Integer id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElseThrow();
        return etudiantMapper.ENTITY_TO_DTO(etudiant);
    }

    @Override
    public ResponceEtudiantDTO UPDATEEtudiant(Integer id, RequestEtudiantDTO requestEtudiantDTO) {
        Etudiant newetudiant = etudiantMapper.DTO_TO_ENTITY(requestEtudiantDTO, filiereRepository);
        Etudiant etudiant = etudiantRepository.findById(id).orElseThrow();

        if(newetudiant.getNom()!=null) etudiant.setNom(newetudiant.getNom());
        if(newetudiant.getPrenom()!=null) etudiant.setPrenom(newetudiant.getPrenom());
        if(newetudiant.getCne()!=null) etudiant.setCne(newetudiant.getCne());

        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        return etudiantMapper.ENTITY_TO_DTO(savedEtudiant);
    }

    @Override
    public void DELETEEtudiantBYID(Integer id) {
        etudiantRepository.deleteById(id);
    }
}
