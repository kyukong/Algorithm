select product.product_code,
    product.price * off_total.total sales
from product
join (
    select product_id, sum(sales_amount) total
    from offline_sale
    group by product_id) off_total
on product.product_id = off_total.product_id
order by product.price * off_total.total desc,
    product.product_code
;