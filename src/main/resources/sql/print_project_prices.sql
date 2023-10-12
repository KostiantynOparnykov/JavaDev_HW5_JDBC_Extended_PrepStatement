-------------------------------------------------
-- GoIt Java Developer 14. Module 3 homework
-- Kostyantyn Oparnykov
-- Calculate total price for each project(task 7)
-- Postgres
-------------------------------------------------
SELECT 
    project.id AS name,
	(DATE_PART('year',age(finish_date, start_date))*12
    +DATE_PART('month', age(finish_date, start_date)))
	*sum(salary) as price 
FROM project INNER JOIN project_worker
ON project.id = project_id
INNER JOIN worker ON worker.id = worker_id
GROUP BY project.id
ORDER BY price desc;
