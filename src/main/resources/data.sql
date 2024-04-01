DROP TABLE IF EXISTS members;

CREATE TABLE members (
                         id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                         email VARCHAR(255) NOT NULL,
                         username VARCHAR(255) NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         phone_number VARCHAR(20),
                         description VARCHAR(255),
                         role ENUM('USER', 'ADMIN') NOT NULL
) engine=InnoDB;

INSERT INTO members(id, email, username, password, phone_number, description, role)
VALUES (1, 'ansrlgus1tp@naver.com', 'ansrlgus1tp', '$2a$10$xCOOt0xzhINfMXQDIS0HLuT7O7gQVxjPt/j0809Y1ILz22FPLRFVW', '010-1111-1111', 'description1', 'USER'),
       (2, 'ansrlgus2tp@naver.com', 'ansrlgus2tp', '$2a$10$xCOOt0xzhINfMXQDIS0HLuT7O7gQVxjPt/j0809Y1ILz22FPLRFVW', '010-2222-2222', 'description2', 'USER'),
       (3, 'ansrlgus3tp@naver.com', 'ansrlgus3tp', '$2a$10$xCOOt0xzhINfMXQDIS0HLuT7O7gQVxjPt/j0809Y1ILz22FPLRFVW', '010-3333-3333', 'description3', 'USER'),
       (4, 'ansrlgus4tp@naver.com', 'ansrlgus4tp', '$2a$10$xCOOt0xzhINfMXQDIS0HLuT7O7gQVxjPt/j0809Y1ILz22FPLRFVW', '010-4444-4444', 'description4', 'USER'),
       (5, 'ansrlgus5tp@naver.com', 'ansrlgus5tp', '$2a$10$xCOOt0xzhINfMXQDIS0HLuT7O7gQVxjPt/j0809Y1ILz22FPLRFVW', '010-5555-5555', 'description5', 'USER'),
       (6, 'ansrlgus6tp@naver.com', 'ansrlgus6tp', '$2a$10$xCOOt0xzhINfMXQDIS0HLuT7O7gQVxjPt/j0809Y1ILz22FPLRFVW', '010-6666-6666', 'description6', 'USER'),
       (7, 'ansrlgus7tp@naver.com', 'ansrlgus7tp', '$2a$10$xCOOt0xzhINfMXQDIS0HLuT7O7gQVxjPt/j0809Y1ILz22FPLRFVW', '010-7777-7777', 'description7', 'USER'),
       (8, 'ansrlgus8tp@naver.com', 'ansrlgus8tp', '$2a$10$xCOOt0xzhINfMXQDIS0HLuT7O7gQVxjPt/j0809Y1ILz22FPLRFVW', '010-8888-8888', 'description8', 'USER'),
       (9, 'ansrlgus9tp@naver.com', 'ansrlgus9tp', '$2a$10$xCOOt0xzhINfMXQDIS0HLuT7O7gQVxjPt/j0809Y1ILz22FPLRFVW', '010-9999-9999', 'description9', 'USER'),
       (10, 'ansrlgus10tp@naver.com', 'ansrlgus10tp', '$2a$10$xCOOt0xzhINfMXQDIS0HLuT7O7gQVxjPt/j0809Y1ILz22FPLRFVW', '010-0000-0000', 'description10', 'USER'),
       (11, 'admin@naver.com', 'admin', '$2a$10$xCOOt0xzhINfMXQDIS0HLuT7O7gQVxjPt/j0809Y1ILz22FPLRFVW', '010-7777-7777', 'admin', 'ADMIN');