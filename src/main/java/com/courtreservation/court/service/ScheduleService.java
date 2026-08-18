package com.courtreservation.court.service;

import com.courtreservation.court.dto.CreateScheduleDto;
import com.courtreservation.court.dto.ScheduleDto;
import java.util.List;

public interface ScheduleService {
  List<ScheduleDto> findAll();

  ScheduleDto findById(Long id);

  ScheduleDto create(CreateScheduleDto dto);

  ScheduleDto update(Long id, ScheduleDto dto);

  void delete(Long id);
}
