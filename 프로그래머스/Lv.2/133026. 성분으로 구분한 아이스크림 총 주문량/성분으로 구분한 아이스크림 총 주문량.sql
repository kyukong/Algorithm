select ice.ingredient_type,
    sum(first.total_order) total_order
from icecream_info ice
left join (
    select flavor, sum(total_order) total_order
    from first_half
    group by flavor) first
    on ice.flavor = first.flavor
group by ice.ingredient_type
order by sum(first.total_order)
;