INSERT INTO sport (sport_id, sport_name) VALUES
    (1, 'Fútbol'),
    (2, 'Tenis'),
    (3, 'Basketball')
ON CONFLICT (sport_id) DO NOTHING;

INSERT INTO court (court_id, court_name, court_description, court_capacity, court_sport_id, court_price) VALUES
    (1, 'Cancha 1', 'Cancha principal de fútbol con gramilla sintética', 10, 1, 120.00),
    (2, 'Cancha 2', 'Cancha de fútbol para entrenamiento', 8, 1, 100.00),
    (3, 'Cancha de Tenis A', 'Cancha de tenis exterior', 2, 2, 80.00),
    (4, 'Cancha de Basketball', 'Cancha cubierta para basketball', 6, 3, 140.00)
ON CONFLICT (court_id) DO NOTHING;

INSERT INTO schedule (schedule_id, schedule_day, schedule_court_id, schedule_start, schedule_end) VALUES
    (1, 'MONDAY', 1, '08:00:00', '10:00:00'),
    (2, 'MONDAY', 1, '18:00:00', '20:00:00'),
    (3, 'TUESDAY', 3, '09:00:00', '11:00:00'),
    (4, 'WEDNESDAY', 4, '16:00:00', '18:00:00'),
    (5, 'THURSDAY', 2, '10:00:00', '12:00:00'),
    (6, 'THURSDAY', 2, '18:00:00', '20:00:00'),
    (7, 'FRIDAY', 1, '08:00:00', '10:00:00'),
    (8, 'FRIDAY', 3, '11:00:00', '13:00:00'),
    (9, 'SATURDAY', 4, '09:00:00', '11:00:00'),
    (10, 'SATURDAY', 2, '14:00:00', '16:00:00'),
    (11, 'SUNDAY', 1, '10:00:00', '12:00:00'),
    (12, 'SUNDAY', 4, '16:00:00', '18:00:00')
ON CONFLICT (schedule_id) DO NOTHING;
