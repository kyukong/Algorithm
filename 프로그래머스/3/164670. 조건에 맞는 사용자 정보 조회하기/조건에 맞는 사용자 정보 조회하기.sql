select 
    users.user_id user_id,
    users.nickname nickname,
    users.city || ' ' 
        || users.street_address1 || ' ' 
        || users.street_address2 "전체주소",
    SUBSTR(users.tlno, 1, 3) || '-' 
        || SUBSTR(users.tlno, 4, 4) || '-' 
        || SUBSTR(users.tlno, 8) AS "전화번호"
from (select 
        writer_id, 
        count(*) count
    from used_goods_board
    group by writer_id) counts
join used_goods_user users
on counts.writer_id = users.user_id
where counts.count >= 3
order by users.user_id desc
;
