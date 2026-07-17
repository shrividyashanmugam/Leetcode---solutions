# Write your MySQL query statement below
-- Case 1: Employees who have explicitly decided on their primary department
SELECT 
    employee_id, 
    department_id
FROM 
    Employee
WHERE 
    primary_flag = 'Y'

UNION

-- Case 2: Employees who belong to only one department
SELECT 
    employee_id, 
    department_id
FROM 
    Employee
GROUP BY 
    employee_id
HAVING 
    COUNT(department_id) = 1;