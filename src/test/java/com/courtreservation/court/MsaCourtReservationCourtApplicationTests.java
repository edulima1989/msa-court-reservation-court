package com.courtreservation.court;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
  properties = {
    "app.flyway.force-on-startup=false",
    "spring.flyway.enabled=false",
    "spring.datasource.hikari.initialization-fail-timeout=-1"
  }
)
class MsaCourtReservationCourtApplicationTests {

  @Test
  void contextLoads() {
  }

}
