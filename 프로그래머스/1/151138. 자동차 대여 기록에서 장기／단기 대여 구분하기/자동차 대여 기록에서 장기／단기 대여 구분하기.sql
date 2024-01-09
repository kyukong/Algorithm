-- 2
select history_id, car_id,
    to_char(start_date, 'YYYY-MM-DD') start_date,
    to_char(end_date, 'YYYY-MM-DD') end_date,
    case when end_date - start_date + 1 >= 30 then '장기 대여'
        else '단기 대여' end rent_type
from (
    select *
    from car_rental_company_rental_history
    where to_char(start_date, 'YYYY-MM') = '2022-09')
order by history_id desc
;