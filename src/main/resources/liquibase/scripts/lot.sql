-- liquibase formatted sql

-- changeset V:1
CREATE TABLE lot (
    id SERIAL PRIMARY KEY,
    status VARCHAR(10) NOT NULL CHECK ( status IN ('CREATED', 'STOPPED', 'STARTED')),
    title VARCHAR(64) NOT NULL,
    description VARCHAR(4096) NOT NULL ,
    start_price INTEGER NOT NULL ,
    bid_price INTEGER NOT NULL
);
