package com.courtreservation.court.service;

import com.courtreservation.court.dto.CreateMaintenanceBlockDto;
import com.courtreservation.court.dto.MaintenanceBlockDto;
import java.util.List;

public interface MaintenanceBlockService {
  List<MaintenanceBlockDto> findAll();

  MaintenanceBlockDto findById(Long id);

  MaintenanceBlockDto create(CreateMaintenanceBlockDto dto);

  MaintenanceBlockDto update(Long id, MaintenanceBlockDto dto);

  void delete(Long id);
}
