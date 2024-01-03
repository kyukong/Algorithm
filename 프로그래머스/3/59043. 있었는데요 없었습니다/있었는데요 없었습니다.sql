select ins.animal_id animal_id,
    ins.name name
from animal_ins ins
join animal_outs outs
    on ins.animal_id = outs.animal_id
where outs.datetime < ins.datetime
order by ins.datetime
;