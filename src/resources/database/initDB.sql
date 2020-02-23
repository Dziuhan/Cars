create database Cars;
use Cars;

CREATE TABLE roles(
                      id INTEGER NOT NULL auto_increment PRIMARY KEY,
                      role varchar(20) not null unique
);

CREATE TABLE users(
                      id INTEGER   NOT NULL auto_increment PRIMARY KEY,
                      login varchar(15) not null unique,
                      password varchar(15) not null,
                      role_id INTEGER  not null REFERENCES roles(id),
                      ban BOOLEAN not null  DEFAULT false
);

CREATE TABLE cars(
                     id INTEGER NOT NULL auto_increment PRIMARY KEY,
                     producer varchar(20),
                     make varchar(20),
                     rang varchar(20),
                     price REAL,
                     year int,
                     imageLocAdress varchar(40),
                     active boolean not null  default true
);

CREATE TABLE orders(
                       id INTEGER NOT NULL auto_increment PRIMARY KEY,
                       user_id INTEGER NOT NULL REFERENCES users(id),
                       car_id INTEGER NOT NULL REFERENCES cars(id),
                       start_rent DATE NOT NULL,
                       finish_rent DATE NOT NULL,
                       state varchar(20) not null  default 'new order',
                       priceTotal DECIMAL not null  default 0,
                       driver boolean  default false,
                       priceCrush DECIMAL not null  default 0
);


CREATE TABLE reviewsCars(
                            id INTEGER NOT NULL auto_increment PRIMARY KEY,
                            user_id INTEGER NOT NULL REFERENCES users(id),
                            car_id INTEGER NOT NULL REFERENCES cars(id),
                            dateReview DATE NOT NULL,
                            review varchar(500) not null
);