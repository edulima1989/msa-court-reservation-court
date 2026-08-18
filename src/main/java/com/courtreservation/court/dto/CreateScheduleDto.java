package com.courtreservation.court.dto;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateScheduleDto {
  private String scheduleDay;
  private Long scheduleCourtId;
  private LocalTime scheduleStart;
  private LocalTime scheduleEnd;
}
