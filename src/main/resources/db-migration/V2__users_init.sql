create table users
(
    id       bigserial
        primary key,
    password varchar(255),
    role     varchar(255),
    username varchar(255)
);

INSERT INTO users (username, password, role)
VALUES ('admin', '$2a$10$GvfSOnNm3vnG8yGzFH9IU.yciH7iLowEXzJApTVVTDi3ixJW093r.', 'ADMIN');
-- Raw password: 12345

INSERT INTO users (username, password, role)
VALUES ('user', '$2a$10$GvfSOnNm3vnG8yGzFH9IU.yciH7iLowEXzJApTVVTDi3ixJW093r.', 'USER');
-- Raw password: 12345
