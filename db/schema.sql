CREATE TABLE post (
   id SERIAL PRIMARY KEY,
   name TEXT
);

CREATE TABLE users (
   id SERIAL PRIMARY KEY,
   login TEXT,
   password TEXT,
   email TEXT
);

CREATE TABLE candidate (
   id SERIAL PRIMARY KEY,
   name TEXT,
   photoid INTEGER
);

CREATE TABLE photos (
   id SERIAL PRIMARY KEY,
   filename TEXT
);
