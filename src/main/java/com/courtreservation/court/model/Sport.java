package com.courtreservation.court.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "sport")
public class Sport {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sport_id")
  private Long id;

  @Column(name = "sport_name", nullable = false, length = 100)
  private String name;
}
