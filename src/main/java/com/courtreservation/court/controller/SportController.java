package com.courtreservation.court.controller;

import com.courtreservation.court.dto.CreateSportDto;
import com.courtreservation.court.dto.SportDto;
import com.courtreservation.court.service.SportService;
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
@RequestMapping("/api/sports")
@Tag(name = "Sports", description = "CRUD de deportes")
public class SportController {

  private final SportService sportService;

  public SportController(SportService sportService) {
    this.sportService = sportService;
  }

  @GetMapping
  @Operation(summary = "Listar deportes")
  @ApiResponse(responseCode = "200", description = "Lista de deportes obtenida")
  public List<SportDto> findAll() {
    return sportService.findAll();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Obtener deporte por ID")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Deporte encontrado"),
      @ApiResponse(responseCode = "404", description = "Deporte no encontrado")
  })
  public SportDto findById(@Parameter(description = "ID del deporte") @PathVariable Long id) {
    return sportService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Crear deporte")
  @ApiResponse(responseCode = "201", description = "Deporte creado")
  public SportDto create(@RequestBody CreateSportDto dto) {
    return sportService.create(dto);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Actualizar deporte")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Deporte actualizado"),
      @ApiResponse(responseCode = "404", description = "Deporte no encontrado")
  })
  public SportDto update(@Parameter(description = "ID del deporte") @PathVariable Long id, @RequestBody SportDto dto) {
    return sportService.update(id, dto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Eliminar deporte")
  @ApiResponses({
      @ApiResponse(responseCode = "204", description = "Deporte eliminado"),
      @ApiResponse(responseCode = "404", description = "Deporte no encontrado")
  })
  public void delete(@Parameter(description = "ID del deporte") @PathVariable Long id) {
    sportService.delete(id);
  }
}
