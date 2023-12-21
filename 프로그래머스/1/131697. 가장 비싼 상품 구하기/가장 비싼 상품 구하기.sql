select price max_price
from (
    select *
    from product
    order by price desc)
where rownum = 1
;