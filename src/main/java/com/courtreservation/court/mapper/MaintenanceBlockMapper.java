package com.courtreservation.court.mapper;

import com.courtreservation.court.dto.CreateMaintenanceBlockDto;
import com.courtreservation.court.dto.MaintenanceBlockDto;
import com.courtreservation.court.model.Court;
import com.courtreservation.court.model.MaintenanceBlock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MaintenanceBlockMapper {

  @Mapping(target = "maintenanceBlockId", source = "id")
  @Mapping(target = "maintenanceBlockCourtId", source = "court.id")
  @Mapping(target = "maintenanceBlockStartDate", source = "startDate")
  @Mapping(target = "maintenanceBlockEndDate", source = "endDate")
  @Mapping(target = "maintenanceBlockReason", source = "reason")
  MaintenanceBlockDto toDto(MaintenanceBlock maintenanceBlock);

  @Mapping(target = "id", source = "dto.maintenanceBlockId")
  @Mapping(target = "court", source = "court")
  @Mapping(target = "startDate", source = "dto.maintenanceBlockStartDate")
  @Mapping(target = "endDate", source = "dto.maintenanceBlockEndDate")
  @Mapping(target = "reason", source = "dto.maintenanceBlockReason")
  MaintenanceBlock toEntity(MaintenanceBlockDto dto, Court court);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "court", source = "court")
  @Mapping(target = "startDate", source = "dto.maintenanceBlockStartDate")
  @Mapping(target = "endDate", source = "dto.maintenanceBlockEndDate")
  @Mapping(target = "reason", source = "dto.maintenanceBlockReason")
  MaintenanceBlock toEntity(CreateMaintenanceBlockDto dto, Court court);
}
