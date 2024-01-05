select rest1.food_type,
    rest1.rest_id,
    rest1.rest_name,
    rest2.favorites
from rest_info rest1
join (
    select food_type, max(favorites) favorites
    from rest_info
    group by food_type) rest2
    on rest1.food_type = rest2.food_type
        and rest1.favorites = rest2.favorites
order by rest1.food_type desc
;