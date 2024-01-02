select 
    substr(product_code, 0, 2) category_code,
    count(*) products
from product
group by substr(product_code, 0, 2)
order by substr(product_code, 0, 2)
;