select product_group, count(*) products
from (
    select product_id, product_code, price,
        floor(price / 10000) * 10000 product_group
    from product)
group by product_group
order by product_group
;