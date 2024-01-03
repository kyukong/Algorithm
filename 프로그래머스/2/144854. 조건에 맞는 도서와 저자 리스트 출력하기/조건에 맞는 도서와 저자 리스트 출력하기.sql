select book.book_id book_id,
    author.author_name author_name,
    to_char(book.published_date, 'YYYY-MM-DD') published_date
from book
join author
    on book.author_id = author.author_id
where book.category = '경제'
order by book.published_date
;