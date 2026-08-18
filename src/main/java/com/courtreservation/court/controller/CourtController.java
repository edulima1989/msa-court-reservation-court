package com.courtreservation.court.controller;

import com.courtreservation.court.dto.CreateCourtDto;
import com.courtreservation.court.dto.CourtDto;
import com.courtreservation.court.service.CourtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courts")
@Tag(name = "Courts", description = "CRUD de canchas")
public class CourtController {

  private final CourtService courtService;

  public CourtController(CourtService courtService) {
    this.courtService = courtService;
  }

  @GetMapping
  @Operation(summary = "Listar canchas")
  @ApiResponse(responseCode = "200", description = "Lista de canchas obtenida")
  public List<CourtDto> findAll() {
    return courtService.findAll();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Obtener cancha por ID")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Cancha encontrada"),
      @ApiResponse(responseCode = "404", description = "Cancha no encontrada")
  })
  public CourtDto findById(@Parameter(description = "ID de la cancha") @PathVariable Long id) {
    return courtService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Crear cancha")
  @ApiResponse(responseCode = "201", description = "Cancha creada")
  public CourtDto create(@RequestBody CreateCourtDto dto) {
    return courtService.create(dto);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Actualizar cancha")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Cancha actualizada"),
      @ApiResponse(responseCode = "404", description = "Cancha no encontrada")
  })
  public CourtDto update(@Parameter(description = "ID de la cancha") @PathVariable Long id, @RequestBody CourtDto dto) {
    return courtService.update(id, dto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Eliminar cancha")
  @ApiResponses({
      @ApiResponse(responseCode = "204", description = "Cancha eliminada"),
      @ApiResponse(responseCode = "404", description = "Cancha no encontrada")
  })
  public void delete(@Parameter(description = "ID de la cancha") @PathVariable Long id) {
    courtService.delete(id);
  }
}
