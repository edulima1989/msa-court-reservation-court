package com.courtreservation.court.mapper;

import com.courtreservation.court.dto.CreateSportDto;
import com.courtreservation.court.dto.SportDto;
import com.courtreservation.court.model.Sport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SportMapper {

  @Mapping(target = "sportId", source = "id")
  @Mapping(target = "sportName", source = "name")
  SportDto toDto(Sport sport);

  @Mapping(target = "id", source = "sportId")
  @Mapping(target = "name", source = "sportName")
  Sport toEntity(SportDto dto);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "name", source = "sportName")
  Sport toEntity(CreateSportDto dto);
}
