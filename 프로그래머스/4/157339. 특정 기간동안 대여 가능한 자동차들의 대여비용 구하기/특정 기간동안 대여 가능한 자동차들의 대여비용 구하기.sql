select car.car_id, car.car_type, 
    daily_fee * 30 * ((100 - discount_rate) / 100) fee
from CAR_RENTAL_COMPANY_CAR car
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN discount
    on car.car_type = discount.car_type
where car.CAR_TYPE in ('세단', 'SUV')
    and car.car_id not in (
        select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where 
            to_char(end_date, 'YYYY-MM-DD') 
                between '2022-11-01' and '2022-11-30'
            or to_char(start_date, 'YYYY-MM-DD') 
                between '2022-11-01' and '2022-11-30'
            or (to_char(start_date, 'YYYY-MM-DD') <= '2022-11-01'
                and to_char(end_date, 'YYYY-MM-DD') >= '2022-11-30'))
    and duration_type = '30일 이상'
    and daily_fee * 30 * ((100 - discount_rate) / 100) >= 500000
    and daily_fee * 30 * ((100 - discount_rate) / 100) < 2000000
order by fee desc, car.car_type, car.car_id desc
;