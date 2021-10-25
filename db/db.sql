CREATE TABLE IF NOT EXISTS roles(
    id SERIAL PRIMARY KEY,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS "user" (
    id SERIAL NOT NULL PRIMARY KEY ,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role_id INTEGER,
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE IF NOT EXISTS platform (
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR (50) NOT NULL UNIQUE,
    city VARCHAR (50) NOT NULL
);

CREATE TABLE IF NOT EXISTS train (
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    type VARCHAR (50) NOT NULL
);

-- CREATE TABLE IF NOT EXISTS cart (
--     id SERIAL NOT NULL PRIMARY KEY,
--     name VARCHAR (50) NOT NULL,
--     type VARCHAR (50) NOT NULL,
--     train_id INTEGER NOT NULL,
--     FOREIGN KEY (train_id) REFERENCES train (id)
-- );

CREATE TABLE IF NOT EXISTS seat (
    id SERIAL NOT NULL PRIMARY KEY,
    type VARCHAR (50) NOT NULL,
    train_id INTEGER NOT NULL,
    FOREIGN KEY (train_id) REFERENCES train (id)
);

CREATE TABLE IF NOT EXISTS ticket (
    id SERIAL NOT NULL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    price money NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);

CREATE TABLE IF NOT EXISTS route(
    id SERIAL NOT NULL PRIMARY KEY,
    departure_platform_id INTEGER NOT NULL,
    arrival_platform_id INTEGER NOT NULL,
    train_id INTEGER NOT NULL,
    departure_datetime TIMESTAMP NOT NULL,
    arrival_datetime TIMESTAMP  NOT NULL,
    FOREIGN KEY (departure_platform_id) REFERENCES platform (id),
    FOREIGN KEY (arrival_platform_id) REFERENCES platform (id),
    FOREIGN KEY (train_id) REFERENCES train (id)
);


CREATE TABLE IF NOT EXISTS order_details (
    ticket_id INTEGER NOT NULL REFERENCES ticket (id) ON DELETE CASCADE,
    route_id INTEGER NOT NULL REFERENCES route (id) ON DELETE RESTRICT,
    seat_id INTEGER NOT NULL REFERENCES seat (id)  ON DELETE RESTRICT
);


CREATE TABLE IF NOT EXISTS cities_distances (
    platform_id_1 INTEGER NOT NULL REFERENCES platform (id),
    platform_id_2 INTEGER NOT NULL REFERENCES platform (id),
    distance INTEGER NOT NULL
);