select flavor
from (
    select f.flavor flavor
    from first_half f
    join (
        select 
            flavor, sum(total_order) total
        from july
        group by flavor) j
    on f.flavor = j.flavor
    order by f.total_order + j.total desc)
where rownum <= 3
;