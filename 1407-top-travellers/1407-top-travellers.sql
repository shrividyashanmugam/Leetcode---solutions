# Write your MySQL query statement below
SELECT u.name, IFNULL(SUM(r.distance), 0) as travelled_distance
FROM Users u
LEFT JOIN Rides r on u.id=r.user_id
GROUP BY u.id
ORDER BY travelled_distance DESC, u.name ASC