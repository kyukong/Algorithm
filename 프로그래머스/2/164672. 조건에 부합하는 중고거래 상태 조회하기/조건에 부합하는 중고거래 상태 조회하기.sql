select
    board_id,
    writer_id,
    title,
    price,
    case when status = 'SALE' then '판매중'
         when status = 'RESERVED' then '예약중'
         else '거래완료'
    end as status
from used_goods_board
where to_char(created_date, 'YYYY-MM-DD') = '2022-10-05'
order by board_id desc
;