select f.flavor flavor
from first_half f
    join icecream_info ic
    on f.flavor = ic.flavor
where total_order > 3000
    and ingredient_type = 'fruit_based'
order by total_order desc
;