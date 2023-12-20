select
    b.title title,
    b.board_id board_id,
    r.reply_id reply_id,
    r.writer_id writer_id,
    r.contents contents,
    to_char(r.created_date, 'YYYY-MM-DD') created_date
from used_goods_board b
join used_goods_reply r
on b.board_id = r.board_id
where to_char(b.created_date, 'YYYY-MM') = '2022-10'
order by r.created_date, b.title
;