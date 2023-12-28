select distinct(car.car_id) car_id
from car_rental_company_rental_history history
join car_rental_company_car car
    on car.car_id = history.car_id
where car.car_type = '세단'
    and to_char(history.start_date, 'MM') = '10'
order by car.car_id desc
;