select ice.flavor
from icecream_info ice
join first_half first
    on ice.flavor = first.flavor
where ingredient_type = 'fruit_based'
    and ice.flavor in (
        select flavor
        from first_half
        group by flavor
        having sum(total_order) >= 3000)
order by total_order desc
;