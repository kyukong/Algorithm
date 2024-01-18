select category, count(*) products
from (
    select substr(product_code, 0, 2) category
    from product)
group by category
order by category
;