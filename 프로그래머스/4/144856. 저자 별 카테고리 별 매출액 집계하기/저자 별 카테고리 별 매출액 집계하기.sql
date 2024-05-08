select b.author_id, author_name, category, 
    sum(sales * price) total_sales
from book_sales s
join book b
    on b.book_id = s.book_id
join author a
    on b.author_id = a.author_id
where to_char(sales_date, 'YYYY-MM') = '2022-01'
group by b.author_id, author_name, category
order by b.author_id, author_name, category desc
;