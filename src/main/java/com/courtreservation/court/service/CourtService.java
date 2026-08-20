package com.courtreservation.court.service;

import com.courtreservation.court.dto.CreateCourtDto;
import com.courtreservation.court.dto.CourtDto;

import java.time.LocalDate;
import java.util.List;

public interface CourtService {
  List<CourtDto> findAll();

  List<CourtDto> findAvailableCourts(LocalDate date);

  CourtDto findById(Long id);

  CourtDto create(CreateCourtDto dto);

  CourtDto update(Long id, CourtDto dto);

  void delete(Long id);
}
