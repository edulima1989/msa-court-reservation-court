package com.courtreservation.court.repository;

import com.courtreservation.court.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

  boolean existsByCourt_IdAndDayIgnoreCase(Long courtId, String day);

  boolean existsByCourt_IdAndDayIgnoreCaseAndIdNot(Long courtId, String day, Long id);
}
