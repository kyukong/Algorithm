select b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, 
    to_char(r.CREATED_DATE, 'YYYY-MM-DD') as CREATED_DATE
from USED_GOODS_BOARD b
inner join USED_GOODS_REPLY r
on b.board_id = r.board_id
where to_char(b.CREATED_DATE, 'YYYY-MM') = '2022-10'
order by r.CREATED_DATE, b.TITLE
;
