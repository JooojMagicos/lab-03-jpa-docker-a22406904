-- Flyway applies this once and then records its checksum.
-- Never edit a migration that has already run: write V2 instead.
--
-- This is the table the entity on the lab pages maps to, column for column. Hibernate
-- validates the two against each other at startup, so a width that differs here is a
-- service that will not start.

CREATE TABLE product (
    id          uuid           PRIMARY KEY,
    name        varchar(120)   NOT NULL,
    description varchar(2000),
    sku         varchar(255)   NOT NULL,
    price       numeric(14, 2) NOT NULL,
    stock       integer        NOT NULL,
    currency    varchar(3)     NOT NULL,
    version     integer        NOT NULL DEFAULT 0,
    created_at  timestamptz    NOT NULL,
    updated_at  timestamptz    NOT NULL,

    CONSTRAINT uk_product_sku UNIQUE (sku),
    CONSTRAINT ck_product_stock_non_negative CHECK (stock >= 0)
);

CREATE INDEX idx_product_currency ON product (currency);
