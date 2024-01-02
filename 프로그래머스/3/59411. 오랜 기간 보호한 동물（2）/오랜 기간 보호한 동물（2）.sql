select animal_id, name
from (
    select 
        ins.animal_id animal_id,
        ins.name name,
        outs.datetime - ins.datetime + 1 datetime
    from animal_ins ins
    join animal_outs outs
        on ins.animal_id = outs.animal_id
    order by outs.datetime - ins.datetime + 1 desc)
where rownum <= 2
;