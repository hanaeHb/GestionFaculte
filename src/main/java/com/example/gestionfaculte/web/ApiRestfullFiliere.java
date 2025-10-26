package com.example.gestionfaculte.web;

import com.example.gestionfaculte.dto.RequestFiliereDto;
import com.example.gestionfaculte.dto.ResponceFiliereDto;
import com.example.gestionfaculte.service.FiliereServiceImpl;
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
                title = "Gestion des filieres",
                description = "Ce service permet de gérer les filières.",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8082"
        )
)

@RestController
@RequestMapping("/v1/filieres")
public class ApiRestfullFiliere {

    private FiliereServiceImpl filiereService;
    public ApiRestfullFiliere (FiliereServiceImpl filiereService) {
        this.filiereService = filiereService;
    }

    @Operation(
            summary = " Ajouter un filiere",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestFiliereDto.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponceFiliereDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PostMapping
    public ResponseEntity<ResponceFiliereDto> add(@RequestBody RequestFiliereDto requestFiliereDto) {
        ResponceFiliereDto responceFiliereDto = filiereService.AddFiliere(requestFiliereDto);
        return ResponseEntity.ok(responceFiliereDto);

    }

    @Operation(
            summary = " récuperer liste des filieres",

            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ResponceFiliereDto.class ))
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @GetMapping
    public ResponseEntity<List<ResponceFiliereDto>> getAll() {

        List<ResponceFiliereDto> filiereDtos = filiereService.GETALLFilieres();
        return ResponseEntity.ok(filiereDtos);
    }

    @Operation(
            summary = " récupérer filiere par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien récuperer",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponceFiliereDto.class )
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @GetMapping("/{id}")
    public ResponseEntity<ResponceFiliereDto> getFiliereById(@PathVariable Integer id) {
        ResponceFiliereDto responceFiliereDto = filiereService.GETFiliereById(id);
        return ResponseEntity.ok(responceFiliereDto);
    }


    @Operation(
            summary = " Modifier un filiere",
            parameters = @Parameter(name = "id", required = true),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestFiliereDto.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien modifier",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponceFiliereDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PutMapping("/{id}")
    public ResponseEntity<ResponceFiliereDto> update(@PathVariable Integer id,
                                                    @RequestBody RequestFiliereDto requestFiliereDto) {
        ResponceFiliereDto responceFiliereDto = filiereService.UPDATEFiliere(id, requestFiliereDto);
        return ResponseEntity.ok(responceFiliereDto);
    }

    @Operation(
            summary = " supprimer filiere par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien supprimer"),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        filiereService.DELETEFiliereBYID(id);
        return ResponseEntity.ok().build();
    }
}
