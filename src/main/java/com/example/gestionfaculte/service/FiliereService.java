package com.example.gestionfaculte.service;

import com.example.gestionfaculte.dto.RequestFiliereDto;
import com.example.gestionfaculte.dto.ResponceFiliereDto;
import org.apache.catalina.connector.ResponseFacade;

import java.util.List;

public interface FiliereService {
    public ResponceFiliereDto AddFiliere(RequestFiliereDto requestFiliereDto);
    public List< ResponceFiliereDto> GETALLFilieres();
    public ResponceFiliereDto GETFiliereById(Integer id);
    public ResponceFiliereDto UPDATEFiliere(Integer id , RequestFiliereDto requestFiliereDto);
    public void DELETEFiliereBYID(Integer id);
}
