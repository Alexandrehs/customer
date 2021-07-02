CREATE TABLE address (
    id VARCHAR(100) PRIMARY KEY,
    road VARCHAR(100) NOT NULL,
    district VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(50) NOT NULL,
    postalCode VARCHAR(8) NOT NULL UNIQUE
);

ALTER TABLE customers
    ADD COLUMN address_id VARCHAR(36),
    ADD COLUMN number_of_road VARCHAR(5),
    ADD COLUMN complement VARCHAR(100),
    ADD CONSTRAINT fk_address
            FOREIGN KEY (address_id)
                REFERENCES address(id)
;