-------------------------------------------------
-- GoIt Java Developer 14. Module 3 homework
-- Kostyantyn Oparnykov
-- Find longest project duration in month(task 5)
-- Postgres
-------------------------------------------------
WITH ProjectDurations AS (
    SELECT
        id,
	DATE_PART('year', age(finish_date, start_date))*12
	+DATE_PART('month', age(finish_date, start_date)) AS project_duration        
    FROM project
)
SELECT
    id,
    project_duration
FROM ProjectDurations
WHERE project_duration = (SELECT MAX(project_duration) FROM ProjectDurations);