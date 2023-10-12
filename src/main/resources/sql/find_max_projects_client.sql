-----------------------------------------------
-- GoIt Java Developer 14. Module 3 homework
-- Kostyantyn Oparnykov
-- Find client with max projects count (task 4)
-- Postgres
-----------------------------------------------
SELECT client.name, COUNT(project.id) AS project_count
FROM client INNER JOIN project
ON client.id = project.client_id
GROUP BY client.name
HAVING COUNT(project.id)=(
   SELECT MAX(project_count)
   FROM(
     SELECT COUNT(project.id) as project_count
     FROM project
     GROUP BY client_id
  )
);