package com.courtreservation.court.service;

import com.courtreservation.court.dto.CreateCourtDto;
import com.courtreservation.court.dto.CourtDto;
import java.util.List;

public interface CourtService {
  List<CourtDto> findAll();

  CourtDto findById(Long id);

  CourtDto create(CreateCourtDto dto);

  CourtDto update(Long id, CourtDto dto);

  void delete(Long id);
}
