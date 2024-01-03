select product.product_id product_id,
    product.product_name product_name,
    product.price * orders.total total_sales
from food_product product
join (
    select product_id, sum(amount) total
    from food_order
    where to_char(produce_date, 'YYYY-MM') = '2022-05'
    group by product_id) orders
on product.product_id = orders.product_id
order by product.price * orders.total desc, product_id
;