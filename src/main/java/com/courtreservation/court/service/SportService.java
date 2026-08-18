package com.courtreservation.court.service;

import com.courtreservation.court.dto.CreateSportDto;
import com.courtreservation.court.dto.SportDto;
import java.util.List;

public interface SportService {
  List<SportDto> findAll();

  SportDto findById(Long id);

  SportDto create(CreateSportDto dto);

  SportDto update(Long id, SportDto dto);

  void delete(Long id);
}
