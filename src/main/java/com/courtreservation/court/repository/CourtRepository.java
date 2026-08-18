package com.courtreservation.court.repository;

import com.courtreservation.court.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<Court, Long> {
}
