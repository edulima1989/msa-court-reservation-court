package com.courtreservation.court.controller;

import com.courtreservation.court.dto.CreateScheduleDto;
import com.courtreservation.court.dto.ScheduleDto;
import com.courtreservation.court.service.ScheduleService;
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
@RequestMapping("/api/schedules")
@Tag(name = "Schedules", description = "CRUD de horarios")
public class ScheduleController {

  private final ScheduleService scheduleService;

  public ScheduleController(ScheduleService scheduleService) {
    this.scheduleService = scheduleService;
  }

  @GetMapping
  @Operation(summary = "Listar horarios")
  @ApiResponse(responseCode = "200", description = "Lista de horarios obtenida")
  public List<ScheduleDto> findAll() {
    return scheduleService.findAll();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Obtener horario por ID")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Horario encontrado"),
      @ApiResponse(responseCode = "404", description = "Horario no encontrado")
  })
  public ScheduleDto findById(@Parameter(description = "ID del horario") @PathVariable Long id) {
    return scheduleService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Crear horario")
  @ApiResponse(responseCode = "201", description = "Horario creado")
  public ScheduleDto create(@RequestBody CreateScheduleDto dto) {
    return scheduleService.create(dto);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Actualizar horario")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Horario actualizado"),
      @ApiResponse(responseCode = "404", description = "Horario no encontrado")
  })
  public ScheduleDto update(@Parameter(description = "ID del horario") @PathVariable Long id, @RequestBody ScheduleDto dto) {
    return scheduleService.update(id, dto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Eliminar horario")
  @ApiResponses({
      @ApiResponse(responseCode = "204", description = "Horario eliminado"),
      @ApiResponse(responseCode = "404", description = "Horario no encontrado")
  })
  public void delete(@Parameter(description = "ID del horario") @PathVariable Long id) {
    scheduleService.delete(id);
  }
}
