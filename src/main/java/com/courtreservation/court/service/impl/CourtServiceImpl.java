package com.courtreservation.court.service.impl;

import com.courtreservation.court.dto.CreateCourtDto;
import com.courtreservation.court.dto.CourtDto;
import com.courtreservation.court.mapper.CourtMapper;
import com.courtreservation.court.model.Court;
import com.courtreservation.court.model.Sport;
import com.courtreservation.court.repository.CourtRepository;
import com.courtreservation.court.repository.SportRepository;
import com.courtreservation.court.service.CourtService;

import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CourtServiceImpl implements CourtService {

  private final CourtRepository courtRepository;
  private final SportRepository sportRepository;
  private final CourtMapper courtMapper;

  public CourtServiceImpl(CourtRepository courtRepository, SportRepository sportRepository, CourtMapper courtMapper) {
    this.courtRepository = courtRepository;
    this.sportRepository = sportRepository;
    this.courtMapper = courtMapper;
  }

  @Override
  public List<CourtDto> findAll() {
    return courtRepository.findAll().stream().map(courtMapper::toDto).toList();
  }

  @Override
  public List<CourtDto> findAvailableCourts(LocalDate date) {
    return courtRepository.findCourtsWithScheduleByDay(date.getDayOfWeek().name(), date).stream().map(courtMapper::toDto).toList();
  }

  @Override
  public CourtDto findById(Long id) {
    return courtMapper.toDto(getCourtOrThrow(id));
  }

  @Override
  public CourtDto create(CreateCourtDto dto) {
    Sport sport = getSportOrThrow(dto.getCourtSportId());
    Court court = courtMapper.toEntity(dto, sport);
    court.setActive(Boolean.TRUE);
    Court saved = courtRepository.save(court);
    return courtMapper.toDto(saved);
  }

  @Override
  public CourtDto update(Long id, CourtDto dto) {
    Court court = getCourtOrThrow(id);
    court.setName(dto.getCourtName());
    court.setDescription(dto.getCourtDescription());
    court.setCapacity(dto.getCourtCapacity());
    court.setPrice(dto.getCourtPrice());
    court.setSport(getSportOrThrow(dto.getCourtSportId()));
    return courtMapper.toDto(courtRepository.save(court));
  }

  @Override
  public CourtDto updateActive(Long id, boolean active) {
    Court court = getCourtOrThrow(id);
    court.setActive(active);
    return courtMapper.toDto(courtRepository.save(court));
  }

  @Override
  public void delete(Long id) {
    Court court = getCourtOrThrow(id);
    courtRepository.delete(court);
  }

  private Court getCourtOrThrow(Long id) {
    return courtRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Court not found"));
  }

  private Sport getSportOrThrow(Long id) {
    return sportRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sport not found"));
  }
}
