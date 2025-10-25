package com.example.gestionfaculte.service;

import com.example.gestionfaculte.dto.RequestFiliereDto;
import com.example.gestionfaculte.dto.ResponceFiliereDto;
import com.example.gestionfaculte.mappers.FiliereMapper;
import com.example.gestionfaculte.repository.FiliereRepository;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public List<ResponceFiliereDto> GETALLFilieres() {
        return List.of();
    }

    @Override
    public ResponceFiliereDto GETFiliereById(Integer id) {
        return null;
    }

    @Override
    public ResponceFiliereDto UPDATEFiliere(Integer id, RequestFiliereDto requestFiliereDto) {
        return null;
    }

    @Override
    public void DELETEFiliereBYID(Integer id) {

    }
}
