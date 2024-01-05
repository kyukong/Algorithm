select book.category, sum(total) total_sales
from book
join (
    select book_id, sum(sales) total
    from book_sales
    where to_char(sales_date, 'YYYY-MM') = '2022-01'
    group by book_id) sales
    on book.book_id = sales.book_id
group by book.category
order by book.category
;