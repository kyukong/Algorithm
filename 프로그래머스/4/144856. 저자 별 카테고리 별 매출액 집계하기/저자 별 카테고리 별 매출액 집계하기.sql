select
    author_id,
    author_name,
    category,
    sum(total_sales) total_sales
from (
    select
        book.author_id author_id,
        author.author_name author_name,
        book.category category,
        sales.sales * book.price total_sales
    from book
        join book_sales sales
        on book.book_id = sales.book_id
        join author
        on book.author_id = author.author_id
    where to_char(sales.sales_date, 'YYYY-MM') = '2022-01')
group by author_id, category, author_name
order by author_id, category desc
;