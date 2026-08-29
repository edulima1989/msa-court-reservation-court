package com.courtreservation.court.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "court")
public class Court {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "court_id")
  private Long id;

  @Column(name = "court_name", nullable = false, length = 150)
  private String name;

  @Column(name = "court_description", length = 500)
  private String description;

  @Column(name = "court_capacity", nullable = false)
  private Integer capacity;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "court_sport_id", nullable = false)
  private Sport sport;

  @Column(name = "court_price", nullable = false, precision = 10, scale = 2)
  private BigDecimal price;

  @Builder.Default
  @Column(name = "court_active", nullable = false)
  private Boolean active = Boolean.TRUE;

  @Builder.Default
  @OneToMany(mappedBy = "court", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Schedule> schedules = new ArrayList<>();

  @Builder.Default
  @OneToMany(mappedBy = "court", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<MaintenanceBlock> maintenanceBlocks = new ArrayList<>();
}
