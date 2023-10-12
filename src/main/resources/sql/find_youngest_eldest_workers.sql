-------------------------------------------
-- GoIt Java Developer 14. Module 3 homework
-- Kostyantyn Oparnykov
-- Find youngest and eldest workers(task 6)
-- Postgres
-------------------------------------------
SELECT 
    'YOUNGEST' AS TYPE, name, birthday
FROM worker
WHERE birthday = (SELECT MAX(birthday) FROM worker)

UNION ALL

SELECT 'OLDEST' AS TYPE, name, birthday
FROM worker
WHERE birthday = (SELECT MIN(birthday) FROM worker);