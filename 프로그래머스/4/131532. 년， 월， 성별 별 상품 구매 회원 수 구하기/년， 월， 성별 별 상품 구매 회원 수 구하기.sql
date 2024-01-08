select year, month, gender, count(*) users
from (
    select 
        distinct(user_id) user_id,
        extract(year from sales_date) year,
        extract(month from sales_date) month
    from online_sale) onlines
join (
    select user_id, gender
    from user_info) users
    on users.user_id = onlines.user_id
where gender is not null
group by year, month, gender
order by year, month, gender
;