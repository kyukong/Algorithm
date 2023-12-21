select distinct
    o1.user_id user_id,
    o1.product_id product_id
from online_sale o1
join online_sale o2
on o1.online_sale_id != o2.online_sale_id
    and o1.user_id = o2.user_id
    and o1.product_id = o2.product_id
order by user_id, product_id desc
;