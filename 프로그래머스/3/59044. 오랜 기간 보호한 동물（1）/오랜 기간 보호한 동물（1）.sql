select name, datetime
from (
    select ins.*
    from animal_ins ins
    left join animal_outs outs
        on ins.animal_id = outs.animal_id
    where outs.animal_id is null
    order by ins.datetime) animal
where rownum <= 3
;