package com.courtreservation.court.mapper;

import com.courtreservation.court.dto.CreateCourtDto;
import com.courtreservation.court.dto.CourtDto;
import com.courtreservation.court.model.Court;
import com.courtreservation.court.model.Sport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourtMapper {

  @Mapping(target = "courtId", source = "id")
  @Mapping(target = "courtName", source = "name")
  @Mapping(target = "courtDescription", source = "description")
  @Mapping(target = "courtCapacity", source = "capacity")
  @Mapping(target = "courtSportId", source = "sport.id")
  @Mapping(target = "courtPrice", source = "price")
  CourtDto toDto(Court court);

  @Mapping(target = "id", source = "dto.courtId")
  @Mapping(target = "name", source = "dto.courtName")
  @Mapping(target = "description", source = "dto.courtDescription")
  @Mapping(target = "capacity", source = "dto.courtCapacity")
  @Mapping(target = "sport", source = "sport")
  @Mapping(target = "price", source = "dto.courtPrice")
  Court toEntity(CourtDto dto, Sport sport);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "name", source = "dto.courtName")
  @Mapping(target = "description", source = "dto.courtDescription")
  @Mapping(target = "capacity", source = "dto.courtCapacity")
  @Mapping(target = "sport", source = "sport")
  @Mapping(target = "price", source = "dto.courtPrice")
  Court toEntity(CreateCourtDto dto, Sport sport);
}
