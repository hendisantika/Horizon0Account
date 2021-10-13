CREATE TABLE Account
(
    id         bigint NOT NULL,
    login_id   varchar(255),
    login_name varchar(255),
    status     varchar(255),
    type       varchar(255),
    PRIMARY KEY (id)
);

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;
