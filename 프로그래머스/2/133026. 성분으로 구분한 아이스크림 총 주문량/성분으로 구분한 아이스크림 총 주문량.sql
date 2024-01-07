select ice.ingredient_type, sum(total_order) total_order
from first_half first
join icecream_info ice
    on first.flavor = ice.flavor
group by ice.ingredient_type
order by total_order
;