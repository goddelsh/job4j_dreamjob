CREATE TABLE post (
   id SERIAL PRIMARY KEY,
   name TEXT
);

CREATE TABLE users (
   id SERIAL PRIMARY KEY,
   name TEXT,
   password TEXT,
   email TEXT unique
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
