# Write your MySQL query statement below
# Write your MySQL query statement below
with cte as (
    select id 
    from (
        select email, min(id) as id from Person group by email
    )t
)

delete from Person where id not in (select * from cte);