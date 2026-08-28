package com.courtreservation.court.repository;

import com.courtreservation.court.model.Court;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourtRepository extends JpaRepository<Court, Long> {

  @Override
  @EntityGraph(attributePaths = {"sport", "schedules"})
  List<Court> findAll();

  @Query("""
    SELECT c
    FROM Court c
    JOIN FETCH c.schedules s
    WHERE s.day = :day
      AND c.active = true
      AND NOT EXISTS (
        SELECT 1
        FROM MaintenanceBlock m
        WHERE m.court = c
          AND :date BETWEEN m.startDate AND m.endDate
      )
    ORDER BY c.id   \s
   \s""")
  List<Court> findCourtsWithScheduleByDay(
          @Param("day") String day,
          @Param("date") LocalDate date
          );
}
