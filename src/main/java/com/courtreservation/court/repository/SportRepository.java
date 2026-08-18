package com.courtreservation.court.repository;

import com.courtreservation.court.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {
}
