select b.book_id, a.author_name,
    to_char(b.published_date, 'YYYY-MM-DD') published_date
from book b
join author a
    on b.author_id = a.author_id
where category = '경제'
order by b.published_date
;