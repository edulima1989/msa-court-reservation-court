package com.courtreservation.court.service.impl;

import com.courtreservation.court.dto.CreateMaintenanceBlockDto;
import com.courtreservation.court.dto.MaintenanceBlockDto;
import com.courtreservation.court.mapper.MaintenanceBlockMapper;
import com.courtreservation.court.model.Court;
import com.courtreservation.court.model.MaintenanceBlock;
import com.courtreservation.court.repository.CourtRepository;
import com.courtreservation.court.repository.MaintenanceBlockRepository;
import com.courtreservation.court.service.MaintenanceBlockService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MaintenanceBlockServiceImpl implements MaintenanceBlockService {

  private final MaintenanceBlockRepository maintenanceBlockRepository;
  private final CourtRepository courtRepository;
  private final MaintenanceBlockMapper maintenanceBlockMapper;

  public MaintenanceBlockServiceImpl(
      MaintenanceBlockRepository maintenanceBlockRepository,
      CourtRepository courtRepository,
      MaintenanceBlockMapper maintenanceBlockMapper) {
    this.maintenanceBlockRepository = maintenanceBlockRepository;
    this.courtRepository = courtRepository;
    this.maintenanceBlockMapper = maintenanceBlockMapper;
  }

  @Override
  public List<MaintenanceBlockDto> findAll() {
    return maintenanceBlockRepository.findAll().stream().map(maintenanceBlockMapper::toDto).toList();
  }

  @Override
  public MaintenanceBlockDto findById(Long id) {
    return maintenanceBlockMapper.toDto(getMaintenanceBlockOrThrow(id));
  }

  @Override
  public MaintenanceBlockDto create(CreateMaintenanceBlockDto dto) {
    validateDateRange(dto.getMaintenanceBlockStartDate(), dto.getMaintenanceBlockEndDate());
    Court court = getCourtOrThrow(dto.getMaintenanceBlockCourtId());
    MaintenanceBlock saved = maintenanceBlockRepository.save(maintenanceBlockMapper.toEntity(dto, court));
    return maintenanceBlockMapper.toDto(saved);
  }

  @Override
  public MaintenanceBlockDto update(Long id, MaintenanceBlockDto dto) {
    validateDateRange(dto.getMaintenanceBlockStartDate(), dto.getMaintenanceBlockEndDate());
    MaintenanceBlock maintenanceBlock = getMaintenanceBlockOrThrow(id);
    maintenanceBlock.setCourt(getCourtOrThrow(dto.getMaintenanceBlockCourtId()));
    maintenanceBlock.setStartDate(dto.getMaintenanceBlockStartDate());
    maintenanceBlock.setEndDate(dto.getMaintenanceBlockEndDate());
    maintenanceBlock.setReason(dto.getMaintenanceBlockReason());
    return maintenanceBlockMapper.toDto(maintenanceBlockRepository.save(maintenanceBlock));
  }

  @Override
  public void delete(Long id) {
    MaintenanceBlock maintenanceBlock = getMaintenanceBlockOrThrow(id);
    maintenanceBlockRepository.delete(maintenanceBlock);
  }

  private void validateDateRange(LocalDate startDate, LocalDate endDate) {
    if (startDate == null || endDate == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El rango de fechas del bloqueo es obligatorio");
    }
    if (endDate.isBefore(startDate)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de fin debe ser igual o posterior a la fecha de inicio");
    }
  }

  private MaintenanceBlock getMaintenanceBlockOrThrow(Long id) {
    return maintenanceBlockRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Maintenance block not found"));
  }

  private Court getCourtOrThrow(Long id) {
    return courtRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Court not found"));
  }
}
