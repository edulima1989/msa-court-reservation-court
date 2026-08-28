package com.courtreservation.court.controller;

import com.courtreservation.court.dto.CreateMaintenanceBlockDto;
import com.courtreservation.court.dto.MaintenanceBlockDto;
import com.courtreservation.court.service.MaintenanceBlockService;
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
@RequestMapping("/api/maintenance-blocks")
@Tag(name = "Maintenance Blocks", description = "Bloqueos de mantenimiento de canchas")
public class MaintenanceBlockController {

  private final MaintenanceBlockService maintenanceBlockService;

  public MaintenanceBlockController(MaintenanceBlockService maintenanceBlockService) {
    this.maintenanceBlockService = maintenanceBlockService;
  }

  @GetMapping
  @Operation(summary = "Listar bloqueos de mantenimiento")
  @ApiResponse(responseCode = "200", description = "Lista de bloqueos obtenida")
  public List<MaintenanceBlockDto> findAll() {
    return maintenanceBlockService.findAll();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Obtener bloqueo de mantenimiento por ID")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Bloqueo encontrado"),
      @ApiResponse(responseCode = "404", description = "Bloqueo no encontrado")
  })
  public MaintenanceBlockDto findById(@Parameter(description = "ID del bloqueo") @PathVariable Long id) {
    return maintenanceBlockService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Crear bloqueo de mantenimiento")
  @ApiResponses({
      @ApiResponse(responseCode = "201", description = "Bloqueo creado"),
      @ApiResponse(responseCode = "400", description = "Datos inválidos"),
      @ApiResponse(responseCode = "404", description = "Cancha no encontrada")
  })
  public MaintenanceBlockDto create(@RequestBody CreateMaintenanceBlockDto dto) {
    return maintenanceBlockService.create(dto);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Actualizar bloqueo de mantenimiento")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Bloqueo actualizado"),
      @ApiResponse(responseCode = "400", description = "Datos inválidos"),
      @ApiResponse(responseCode = "404", description = "Bloqueo o cancha no encontrada")
  })
  public MaintenanceBlockDto update(@Parameter(description = "ID del bloqueo") @PathVariable Long id, @RequestBody MaintenanceBlockDto dto) {
    return maintenanceBlockService.update(id, dto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Eliminar bloqueo de mantenimiento")
  @ApiResponses({
      @ApiResponse(responseCode = "204", description = "Bloqueo eliminado"),
      @ApiResponse(responseCode = "404", description = "Bloqueo no encontrado")
  })
  public void delete(@Parameter(description = "ID del bloqueo") @PathVariable Long id) {
    maintenanceBlockService.delete(id);
  }
}
