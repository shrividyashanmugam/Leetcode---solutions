# Write your MySQL query statement below
select pro.product_name,sum(ord.unit) as unit from Products pro 
left join Orders ord on pro.product_id=ord.product_id
where ord.order_date like '2020-02%'
group by ord.product_id
having sum(ord.unit)>=100;