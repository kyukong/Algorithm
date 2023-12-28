select car_id, round(avg(end_date - start_date + 1), 1) average_duration
from car_rental_company_rental_history
group by car_id
having round(avg(end_date - start_date + 1), 2) >= 7
order by average_duration desc, car_id desc
;