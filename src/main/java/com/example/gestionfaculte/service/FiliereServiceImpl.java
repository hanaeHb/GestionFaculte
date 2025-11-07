package com.example.gestionfaculte.service;

import com.example.gestionfaculte.dto.RequestFiliereDto;
import com.example.gestionfaculte.dto.ResponceFiliereDto;
import com.example.gestionfaculte.entity.Filiere;
import com.example.gestionfaculte.mappers.FiliereMapper;
import com.example.gestionfaculte.repository.FiliereRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiliereServiceImpl implements  FiliereService {

    private FiliereRepository  filiereRepository;
    private FiliereMapper filiereMapper;

    public FiliereServiceImpl(FiliereRepository filiereRepository, FiliereMapper filiereMapper) {
        this.filiereRepository = filiereRepository;
        this.filiereMapper = filiereMapper;
    }

    @Override
    public ResponceFiliereDto AddFiliere(RequestFiliereDto requestFiliereDto) {
        Filiere filiere = filiereMapper.DTO_TO_ENTITY(requestFiliereDto);
        Filiere savedFiliere = filiereRepository.save(filiere);
        return filiereMapper.ENTITY_TO_DTO(savedFiliere);
    }

    @Override
    public List<ResponceFiliereDto> GETALLFilieres() {

        List<Filiere> filieres = filiereRepository.findAll();
        List<ResponceFiliereDto> FiliereDtos = new ArrayList<>();
        for (Filiere filiere : filieres) {
            FiliereDtos.add(filiereMapper.ENTITY_TO_DTO(filiere));
        }
        return FiliereDtos;
    }

    @Override
    public ResponceFiliereDto GETFiliereById(Integer id) {
        Filiere filiere = filiereRepository.findById(id).orElseThrow();
        return filiereMapper.ENTITY_TO_DTO(filiere);
    }

    @Override
    public ResponceFiliereDto UPDATEFiliere(Integer id, RequestFiliereDto requestFiliereDto) {
        Filiere newfiliere = filiereMapper.DTO_TO_ENTITY(requestFiliereDto);
        Filiere filiere = filiereRepository.findById(id).orElseThrow();

        if(newfiliere.getCode()!=null) filiere.setCode(newfiliere.getCode());
        if(newfiliere.getLibelle()!=null) filiere.setLibelle(newfiliere.getLibelle());

        Filiere savedFiliere = filiereRepository.save(filiere);
        return filiereMapper.ENTITY_TO_DTO(savedFiliere);
    }

    @Override
    public void DELETEFiliereBYID(Integer id) {
        filiereRepository.deleteById(id);
    }
}
