-- liquibase formatted sql

-- changeset V:1
CREATE TABLE bid (
    id SERIAL PRIMARY KEY ,
    bidder_name VARCHAR(64) NOT NULL,
    bid_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    lot_id INTEGER NOT NULL REFERENCES lot(id)
);