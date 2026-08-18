package com.courtreservation.court.service.impl;

import com.courtreservation.court.dto.CreateSportDto;
import com.courtreservation.court.dto.SportDto;
import com.courtreservation.court.mapper.SportMapper;
import com.courtreservation.court.model.Sport;
import com.courtreservation.court.repository.SportRepository;
import com.courtreservation.court.service.SportService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SportServiceImpl implements SportService {

  private final SportRepository sportRepository;
  private final SportMapper sportMapper;

  public SportServiceImpl(SportRepository sportRepository, SportMapper sportMapper) {
    this.sportRepository = sportRepository;
    this.sportMapper = sportMapper;
  }

  @Override
  public List<SportDto> findAll() {
    return sportRepository.findAll().stream().map(sportMapper::toDto).toList();
  }

  @Override
  public SportDto findById(Long id) {
    return sportMapper.toDto(getSportOrThrow(id));
  }

  @Override
  public SportDto create(CreateSportDto dto) {
    Sport saved = sportRepository.save(sportMapper.toEntity(dto));
    return sportMapper.toDto(saved);
  }

  @Override
  public SportDto update(Long id, SportDto dto) {
    Sport sport = getSportOrThrow(id);
    sport.setName(dto.getSportName());
    return sportMapper.toDto(sportRepository.save(sport));
  }

  @Override
  public void delete(Long id) {
    Sport sport = getSportOrThrow(id);
    sportRepository.delete(sport);
  }

  private Sport getSportOrThrow(Long id) {
    return sportRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sport not found"));
  }
}
