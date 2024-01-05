select car_id, 
    max(case when 
            '2022-10-16' between to_char(start_date, 'YYYY-MM-DD')
                and to_char(end_date, 'YYYY-MM-DD') then '대여중'
        else '대여 가능' end) AVAILABILITY
from car_rental_company_rental_history
group by car_id
order by car_id desc
;