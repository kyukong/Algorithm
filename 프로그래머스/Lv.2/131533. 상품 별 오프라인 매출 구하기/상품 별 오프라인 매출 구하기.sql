select product.product_code,
    amount * price sales
from product
join (
    select product_id, sum(sales_amount) amount
    from offline_sale
    group by product_id) offlines
    on product.product_id = offlines.product_id
order by amount * price desc, product.product_code
;