select price_group, count(*) products
from (
    select product_id,
        product_code,
        price,
        floor(price / 10000) * 10000 price_group
    from product)
group by price_group
order by price_group
;