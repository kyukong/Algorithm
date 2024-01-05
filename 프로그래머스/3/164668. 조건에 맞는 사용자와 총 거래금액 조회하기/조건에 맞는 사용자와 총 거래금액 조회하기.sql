select users.user_id,
    users.nickname,
    board.profit total_sales
from used_goods_user users
join (
    select writer_id, sum(price) profit
    from used_goods_board
    where status = 'DONE'
    group by writer_id) board
    on users.user_id = board.writer_id
where board.profit >= 700000
order by board.profit
;