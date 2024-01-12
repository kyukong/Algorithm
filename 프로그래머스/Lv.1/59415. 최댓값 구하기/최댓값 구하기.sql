select datetime "시간"
from (
    select datetime
    from animal_ins
    order by datetime desc)
where rownum <= 1
;