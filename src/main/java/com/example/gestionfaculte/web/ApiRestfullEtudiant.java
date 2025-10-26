package com.example.gestionfaculte.web;

import com.example.gestionfaculte.dto.RequestEtudiantDTO;
import com.example.gestionfaculte.dto.ResponceEtudiantDTO;
import com.example.gestionfaculte.entity.Filiere;
import com.example.gestionfaculte.service.EtudiantServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/etudiants")
public class ApiRestfullEtudiant {
    private EtudiantServiceImpl etudiantService;
    public ApiRestfullEtudiant (EtudiantServiceImpl etudiantService) {
        this.etudiantService = etudiantService;
    }

    @PostMapping
    public ResponseEntity<ResponceEtudiantDTO> add(@RequestBody RequestEtudiantDTO requestEtudiantDTO) {
        ResponceEtudiantDTO responceEtudiantDTO = etudiantService.AddEtudiant(requestEtudiantDTO);
        return ResponseEntity.ok(responceEtudiantDTO);
    }

    @GetMapping
    public ResponseEntity<List<ResponceEtudiantDTO>> getAll() {

        List<ResponceEtudiantDTO> etudiantDTOS = etudiantService.GETALLEtudiants();
        return ResponseEntity.ok(etudiantDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponceEtudiantDTO> getEtudiantByID(@PathVariable Integer id) {
        ResponceEtudiantDTO responceEtudiantDTO = etudiantService.GETEtudiantById(id);
        return ResponseEntity.ok(responceEtudiantDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponceEtudiantDTO> update(@PathVariable Integer id,
                                                     @RequestBody RequestEtudiantDTO requestEtudiantDTO) {
        ResponceEtudiantDTO responceEtudiantDTO = etudiantService.UPDATEEtudiant(id, requestEtudiantDTO);
        return ResponseEntity.ok(responceEtudiantDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        etudiantService.DELETEEtudiantBYID(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/filiere")
    public ResponseEntity<Filiere> getFiliereByEtudiantId(@PathVariable Integer id) {
        Filiere filiere = etudiantService.getFiliereByEtudiantId(id);
        return ResponseEntity.ok(filiere);
    }
}
