package com.courtreservation.court.service.impl;

import com.courtreservation.court.dto.CreateScheduleDto;
import com.courtreservation.court.dto.ScheduleDto;
import com.courtreservation.court.mapper.ScheduleMapper;
import com.courtreservation.court.model.Court;
import com.courtreservation.court.model.Schedule;
import com.courtreservation.court.repository.CourtRepository;
import com.courtreservation.court.repository.ScheduleRepository;
import com.courtreservation.court.service.ScheduleService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ScheduleServiceImpl implements ScheduleService {

  private final ScheduleRepository scheduleRepository;
  private final CourtRepository courtRepository;
  private final ScheduleMapper scheduleMapper;

  public ScheduleServiceImpl(ScheduleRepository scheduleRepository, CourtRepository courtRepository, ScheduleMapper scheduleMapper) {
    this.scheduleRepository = scheduleRepository;
    this.courtRepository = courtRepository;
    this.scheduleMapper = scheduleMapper;
  }

  @Override
  public List<ScheduleDto> findAll() {
    return scheduleRepository.findAll().stream().map(scheduleMapper::toDto).toList();
  }

  @Override
  public ScheduleDto findById(Long id) {
    return scheduleMapper.toDto(getScheduleOrThrow(id));
  }

  @Override
  public ScheduleDto create(CreateScheduleDto dto) {
    Court court = getCourtOrThrow(dto.getScheduleCourtId());
    Schedule saved = scheduleRepository.save(scheduleMapper.toEntity(dto, court));
    return scheduleMapper.toDto(saved);
  }

  @Override
  public ScheduleDto update(Long id, ScheduleDto dto) {
    Schedule schedule = getScheduleOrThrow(id);
    schedule.setDay(dto.getScheduleDay());
    schedule.setCourt(getCourtOrThrow(dto.getScheduleCourtId()));
    schedule.setStart(dto.getScheduleStart());
    schedule.setEnd(dto.getScheduleEnd());
    return scheduleMapper.toDto(scheduleRepository.save(schedule));
  }

  @Override
  public void delete(Long id) {
    Schedule schedule = getScheduleOrThrow(id);
    scheduleRepository.delete(schedule);
  }

  private Schedule getScheduleOrThrow(Long id) {
    return scheduleRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Schedule not found"));
  }

  private Court getCourtOrThrow(Long id) {
    return courtRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Court not found"));
  }
}
