package com.courtreservation.court.repository;

import com.courtreservation.court.model.Court;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<Court, Long> {

  @Override
  @EntityGraph(attributePaths = {"sport", "schedules"})
  List<Court> findAll();
}
