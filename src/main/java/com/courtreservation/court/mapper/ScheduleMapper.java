package com.courtreservation.court.mapper;

import com.courtreservation.court.dto.CreateScheduleDto;
import com.courtreservation.court.dto.ScheduleDto;
import com.courtreservation.court.model.Court;
import com.courtreservation.court.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

  @Mapping(target = "scheduleId", source = "id")
  @Mapping(target = "scheduleDay", source = "day")
  @Mapping(target = "scheduleCourtId", source = "court.id")
  @Mapping(target = "scheduleStart", source = "start")
  @Mapping(target = "scheduleEnd", source = "end")
  ScheduleDto toDto(Schedule schedule);

  @Mapping(target = "id", source = "dto.scheduleId")
  @Mapping(target = "day", source = "dto.scheduleDay")
  @Mapping(target = "court", source = "court")
  @Mapping(target = "start", source = "dto.scheduleStart")
  @Mapping(target = "end", source = "dto.scheduleEnd")
  Schedule toEntity(ScheduleDto dto, Court court);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "day", source = "dto.scheduleDay")
  @Mapping(target = "court", source = "court")
  @Mapping(target = "start", source = "dto.scheduleStart")
  @Mapping(target = "end", source = "dto.scheduleEnd")
  Schedule toEntity(CreateScheduleDto dto, Court court);
}
