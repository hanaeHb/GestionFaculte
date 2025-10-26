package com.example.gestionfaculte.web;

import com.example.gestionfaculte.dto.RequestEtudiantDTO;
import com.example.gestionfaculte.dto.ResponceEtudiantDTO;
import com.example.gestionfaculte.service.EtudiantServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@OpenAPIDefinition(
        info = @Info(
                title = "Gestion des etudiants",
                description = "Ce service permet de gérer les etudiants.",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8082"
        )
)
@RestController
@RequestMapping("/v1/etudiants")
public class ApiRestfullEtudiant {
    private EtudiantServiceImpl etudiantService;
    public ApiRestfullEtudiant (EtudiantServiceImpl etudiantService) {
        this.etudiantService = etudiantService;
    }

    @Operation(
            summary = " Ajouter un etudiant",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestEtudiantDTO.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponceEtudiantDTO.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PostMapping
    public ResponseEntity<ResponceEtudiantDTO> add(@RequestBody RequestEtudiantDTO requestEtudiantDTO) {
        ResponceEtudiantDTO responceEtudiantDTO = etudiantService.AddEtudiant(requestEtudiantDTO);
        return ResponseEntity.ok(responceEtudiantDTO);
    }

    @Operation(
            summary = " récuperer liste des etudiants",

            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ResponceEtudiantDTO.class ))
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @GetMapping
    public ResponseEntity<List<ResponceEtudiantDTO>> getAll() {

        List<ResponceEtudiantDTO> etudiantDTOS = etudiantService.GETALLEtudiants();
        return ResponseEntity.ok(etudiantDTOS);
    }

    @Operation(
            summary = " récupérer etudiant par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien récuperer",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponceEtudiantDTO.class )
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<ResponceEtudiantDTO> getEtudiantByID(@PathVariable Integer id) {
        ResponceEtudiantDTO responceEtudiantDTO = etudiantService.GETEtudiantById(id);
        return ResponseEntity.ok(responceEtudiantDTO);
    }

    @Operation(
            summary = " Modifier un etudiant",
            parameters = @Parameter(name = "id", required = true),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestEtudiantDTO.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien modifier",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponceEtudiantDTO.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PutMapping("/{id}")
    public ResponseEntity<ResponceEtudiantDTO> update(@PathVariable Integer id,
                                                     @RequestBody RequestEtudiantDTO requestEtudiantDTO) {
        ResponceEtudiantDTO responceEtudiantDTO = etudiantService.UPDATEEtudiant(id, requestEtudiantDTO);
        return ResponseEntity.ok(responceEtudiantDTO);
    }

    @Operation(
            summary = " supprimer etudiant par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien supprimer"),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        etudiantService.DELETEEtudiantBYID(id);
        return ResponseEntity.ok().build();
    }
}
