select member_id,
    member_name,
    gender,
    to_char(date_of_birth, 'YYYY-MM-DD') date_of_birth
from member_profile
where gender = 'W'
    and to_char(date_of_birth, 'MM') = '03'
    and tlno is not null
order by member_id
;