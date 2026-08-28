package com.courtreservation.court.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceBlockDto {
  private Long maintenanceBlockId;
  private Long maintenanceBlockCourtId;
  private LocalDate maintenanceBlockStartDate;
  private LocalDate maintenanceBlockEndDate;
  private String maintenanceBlockReason;
}
