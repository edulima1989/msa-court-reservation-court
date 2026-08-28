package com.courtreservation.court.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "maintenance_block")
public class MaintenanceBlock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "maintenance_block_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "maintenance_block_court_id", nullable = false)
  private Court court;

  @Column(name = "maintenance_block_start_date", nullable = false)
  private LocalDate startDate;

  @Column(name = "maintenance_block_end_date", nullable = false)
  private LocalDate endDate;

  @Column(name = "maintenance_block_reason", length = 500)
  private String reason;
}
