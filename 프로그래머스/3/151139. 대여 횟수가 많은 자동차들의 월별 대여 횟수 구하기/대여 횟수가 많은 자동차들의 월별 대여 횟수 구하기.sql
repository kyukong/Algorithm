select 
    extract(month from start_date) month, 
    car_id, 
    count(*) records
from car_rental_company_rental_history
where 
    extract(month from start_date)
        between 8 and 10
    and car_id in (
        select car_id
        from car_rental_company_rental_history
        where to_char(start_date, 'YYYY-MM')
            between '2022-08' and '2022-10'
        group by car_id
        having count(*) >= 5)
group by extract(month from start_date), car_id
having count(*) <> 0
order by extract(month from start_date), car_id desc
;