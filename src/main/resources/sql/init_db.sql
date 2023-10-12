--------------------------------------------
-- GoIt Java Developer 14. Module 3 homework
-- Kostyantyn Oparnykov
-- DB creation for MegaSoft company (task 1)
-- Postgres
--------------------------------------------
DROP TABLE IF EXISTS
   worker,
   client,
   project,
   project_worker; 
   
--DROP TYPE IF EXISTS worker_level;
--CREATE TYPE  worker_level AS ENUM ('Trainee', 'Junior', 'Middle', 'Senior');

CREATE TABLE Worker
(
   id SERIAL NOT NULL,
   name VARCHAR CHECK (LENGTH(name) >= 2 and LENGTH(name) <=1000),
   birthday DATE,
   level VARCHAR CHECK (level in ('Trainee', 'Junior', 'Middle', 'Senior')),
   salary INT CHECK (salary >= 100 AND salary <= 100000),
   PRIMARY KEY (id)
);

CREATE TABLE client
(
   id SERIAL NOT NULL,
   name VARCHAR CHECK (LENGTH(name) >= 2 and LENGTH(name) <=1000),
   PRIMARY KEY (id)
);

CREATE TABLE project
(
   id SERIAL NOT NULL,
   client_id INT,
   start_date DATE,
   finish_date DATE,
   PRIMARY KEY (id),
   FOREIGN KEY (client_id) REFERENCES client (id)
);

CREATE TABLE project_worker
(
   project_id INT,
   worker_id INT,   
   PRIMARY KEY (project_id, worker_id)
);