CREATE TABLE IF NOT EXISTS sport (
    sport_id BIGSERIAL PRIMARY KEY,
    sport_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS court (
    court_id BIGSERIAL PRIMARY KEY,
    court_name VARCHAR(150) NOT NULL,
    court_description VARCHAR(500),
    court_capacity INTEGER NOT NULL,
    court_sport_id BIGINT NOT NULL,
    court_price NUMERIC(10, 2) NOT NULL,
    CONSTRAINT fk_court_sport FOREIGN KEY (court_sport_id) REFERENCES sport (sport_id)
);

CREATE TABLE IF NOT EXISTS schedule (
    schedule_id BIGSERIAL PRIMARY KEY,
    schedule_day VARCHAR(20) NOT NULL,
    schedule_court_id BIGINT NOT NULL,
    schedule_start TIME NOT NULL,
    schedule_end TIME NOT NULL,
    CONSTRAINT fk_schedule_court FOREIGN KEY (schedule_court_id) REFERENCES court (court_id)
);
