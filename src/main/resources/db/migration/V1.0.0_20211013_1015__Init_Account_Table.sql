CREATE TABLE account
(
    id         serial NOT NULL,
    login_id   varchar(255),
    login_name varchar(255),
    status     varchar(255),
    type       varchar(255),
    PRIMARY KEY (id)
);

CREATE SEQUENCE hibernate_sequence START WITH 6 INCREMENT BY 1;
-- CREATE SEQUENCE account_id_seq START WITH 6 INCREMENT BY 1;
