package com.example.gestionfaculte.service;

import com.example.gestionfaculte.dto.RequestEtudiantDTO;
import com.example.gestionfaculte.dto.ResponceEtudiantDTO;

import java.util.List;

public interface EtudiantService {
    public ResponceEtudiantDTO AddEtudiant(RequestEtudiantDTO requestEtudiantDTO);
    public List<ResponceEtudiantDTO> GETALLEtudiants();
    public ResponceEtudiantDTO GETEtudiantById(Integer id);
    public ResponceEtudiantDTO UPDATEEtudiant(Integer id , RequestEtudiantDTO requestEtudiantDTO);
    public void DELETEEtudiantBYID(Integer id);
}
