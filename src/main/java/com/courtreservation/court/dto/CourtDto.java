package com.courtreservation.court.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourtDto {
  private Long courtId;
  private String courtName;
  private String courtDescription;
  private Integer courtCapacity;
  private Long courtSportId;
  private SportDto courtSport;
  private BigDecimal courtPrice;
  private List<ScheduleDto> courtSchedules;
}
