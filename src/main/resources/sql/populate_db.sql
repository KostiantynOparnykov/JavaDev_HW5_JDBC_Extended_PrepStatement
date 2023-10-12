--------------------------------------------
-- GoIt Java Developer 14. Module 3 homework
-- Kostyantyn Oparnykov
-- DB population for MegaSoft (task 2)
-- Postgres
--------------------------------------------

INSERT INTO worker (name, birthday, level, salary)
VALUES 
   ('Tim Cook', '1960-11-01', 'Senior', '99998'),
   ('Jen Barber', '1978-01-01', 'Middle', '20500'),
   ('David Tennant', '1971-04-17', 'Senior', '50000'),
   ('Maurice Moss', '1977-05-23', 'Middle', '15000'),
   ('J. Fry', '1999-03-28', 'Trainee', '750'),
   ('Stanley Tweedle', '1997-04-18', 'Junior', '1500'),
   ('Matthew Smith', '1982-10-28', 'Junior', '1250'),
   ('Richmond Avenal', '1973-05-21', 'Junior', '1300'),
   ('Roy Trenneman', '1979-10-09', 'Middle', '18000'),
   ('Homer Simpson', '1987-04-19', 'Trainee', '800'),
   ('Fake Cook', '1960-11-01', 'Senior', '99998');


INSERT INTO client (name) 
VALUES 
   ('Bender Rodriguez'),
   ('Peter Capaldi'),
   ('Whittaker'),
   ('J. Farnsworth'),
   ('Turanga Leela');


INSERT INTO project (client_id, start_date, finish_date)
VALUES 
   ('1', '1999-03-28', '1999-11-14'),
   ('1', '2001-12-01', '2002-12-08'),
   ('1', '2008-03-23', '2009-08-30'),
   ('2', '2008-11-21', '2016-05-14'),
   ('3', '2009-04-08', '2012-06-19'),
   ('3', '2010-07-01', '2015-11-26'),
   ('4', '2010-06-24', '2013-09-04'),
   ('5', '2013-02-01', '2014-02-20'),
   ('5', '2020-03-15', '2021-09-04'),
   ('5', '2023-06-24', '2023-09-25');


INSERT INTO project_worker (project_id, worker_id)
VALUES 
   ('1', '1'),
   ('1', '6'),
   ('2', '1'),
   ('3', '2'),
   ('3', '3'),
   ('4', '3'),
   ('4', '4'),
   ('4', '8'),
   ('4', '10'),
   ('4', '9'),
   ('5', '3'),
   ('5', '1'),
   ('5', '2'),
   ('6', '1'),
   ('7', '3'),
   ('7', '8'),
   ('8', '7'),
   ('9', '3'),
   ('10', '6'),
   ('10', '5');