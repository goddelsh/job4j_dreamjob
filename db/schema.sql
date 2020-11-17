CREATE TABLE post (
   id SERIAL PRIMARY KEY,
   name TEXT
);

CREATE TABLE candidate (
   id SERIAL PRIMARY KEY,
   name TEXT,
   photoId INTEGER
);

CREATE TABLE photos (
   id SERIAL PRIMARY KEY,
   filename TEXT
);
