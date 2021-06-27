DROP TABLE IF EXISTS
    customers,
    CASCADE;

CREATE TABLE customers (
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    person_code VARCHAR(11) NOT NULL UNIQUE,
    postal_code VARCHAR(8) NOT NULL,
    email VARCHAR(244) NOT NULL,
    created TIMESTAMP NOT NULL,
    address_id VARCHAR(100),
    numberofroad VARCHAR(5),
    complement VARCHAR(100) NOT NULL,
    CONSTRAINT fk_address
            FOREIGN KEY (address_id)
                REFERENCES address(id)
);