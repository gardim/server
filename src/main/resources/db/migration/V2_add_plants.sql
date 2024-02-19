CREATE TABLE IF NOT EXISTS plants
(
    id           SERIAL PRIMARY KEY,
    name         TEXT,
    photo_url    TEXT,
    latitude     DOUBLE PRECISION,
    longitude    DOUBLE PRECISION,
    FOREIGN KEY (user_id) REFERENCES users (id),
);