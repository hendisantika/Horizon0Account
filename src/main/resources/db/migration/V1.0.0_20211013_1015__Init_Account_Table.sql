CREATE TABLE account
(
    id         bigint NOT NULL,
    login_id   varchar(255),
    login_name varchar(255),
    status     varchar(255),
    type       varchar(255),
    PRIMARY KEY (id)
);

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 6 INCREMENT BY 1;
CREATE SEQUENCE ACCOUNT_ID_SEQ START WITH 6 INCREMENT BY 1;
