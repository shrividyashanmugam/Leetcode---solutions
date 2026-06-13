CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
        SELECT DISTINCT
        t1.salary as getNthHighestSalary
        FROM(
            SELECT
            *,
            dense_rank() over(order by salary desc) as rnk
            FROM Employee) t1
        Where rnk = n
  );
END