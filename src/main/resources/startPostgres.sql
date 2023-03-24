CREATE DATABASE m5l9;

CREATE TABLE IF NOT EXISTS users (
                                         id BIGSERIAL PRIMARY KEY,
                                         login VARCHAR(50),
                                         password VARCHAR(50)
);

INSERT INTO users(login, password) VALUES ( 'YuraLogin', 'qwerty');
INSERT INTO users(login, password) VALUES ( 'DemoLogin', 'ytrewq');
INSERT INTO users(login, password) VALUES ( 'add', 'qqq');
INSERT INTO users(id, login, password) VALUES (10, 'add', 'qqq');

DROP TABLE users;