CREATE TABLE IF NOT EXISTS roles(
    id SERIAL PRIMARY KEY,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS customer (
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

CREATE TABLE IF NOT EXISTS cart (
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    type VARCHAR (50) NOT NULL,
    train_id INTEGER NOT NULL,
    FOREIGN KEY (train_id) REFERENCES train (id)
);

CREATE TABLE IF NOT EXISTS seat (
    id SERIAL NOT NULL PRIMARY KEY,
    type VARCHAR (50) NOT NULL,
    cart_id INTEGER NOT NULL,
    FOREIGN KEY (cart_id) REFERENCES cart (id)
);

CREATE TABLE IF NOT EXISTS "order" (
    id SERIAL NOT NULL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    price money NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

CREATE TABLE IF NOT EXISTS order_details (
    order_id INTEGER NOT NULL REFERENCES "order" (id),
    train_id INTEGER NOT NULL REFERENCES train (id),
    cart_id INTEGER NOT NULL REFERENCES cart (id),
    seat_id INTEGER NOT NULL REFERENCES seat (id),
    platform_id INTEGER NOT NULL REFERENCES platform (id),
    landing_date DATE,
    arrival_date DATE
);

CREATE TABLE IF NOT EXISTS cities_distances (
    platform_id_1 INTEGER NOT NULL REFERENCES platform (id),
    platform_id_2 INTEGER NOT NULL REFERENCES platform (id),
    distance INTEGER NOT NULL
)