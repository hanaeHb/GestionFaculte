package com.example.gestionfaculte.web;

import com.example.gestionfaculte.dto.RequestFiliereDto;
import com.example.gestionfaculte.dto.ResponceFiliereDto;
import com.example.gestionfaculte.service.FiliereServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/filieres")
public class ApiRestfullFiliere {

    private FiliereServiceImpl filiereService;
    public ApiRestfullFiliere (FiliereServiceImpl filiereService) {
        this.filiereService = filiereService;
    }

    @PostMapping
    public ResponseEntity<ResponceFiliereDto> add(@RequestBody RequestFiliereDto requestFiliereDto) {
        ResponceFiliereDto responceFiliereDto = filiereService.AddFiliere(requestFiliereDto);
        return ResponseEntity.ok(responceFiliereDto);

    }

    @GetMapping
    public ResponseEntity<List<ResponceFiliereDto>> getAll() {

        List<ResponceFiliereDto> filiereDtos = filiereService.GETALLFilieres();
        return ResponseEntity.ok(filiereDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponceFiliereDto> getFiliereById(@PathVariable Integer id) {
        ResponceFiliereDto responceFiliereDto = filiereService.GETFiliereById(id);
        return ResponseEntity.ok(responceFiliereDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponceFiliereDto> update(@PathVariable Integer id,
                                                    @RequestBody RequestFiliereDto requestFiliereDto) {
        ResponceFiliereDto responceFiliereDto = filiereService.UPDATEFiliere(id, requestFiliereDto);
        return ResponseEntity.ok(responceFiliereDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        filiereService.DELETEFiliereBYID(id);
        return ResponseEntity.ok().build();
    }
}
