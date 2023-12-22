select
    book.author_id author_id,
    author.author_name author_name,
    book.category category,
    sum(sales.sales * book.price) total_sales
from book
    join book_sales sales
    on book.book_id = sales.book_id
    join author
    on book.author_id = author.author_id
where to_char(sales.sales_date, 'YYYY-MM') = '2022-01'
group by book.author_id, book.category, author.author_name
order by book.author_id, book.category desc
;