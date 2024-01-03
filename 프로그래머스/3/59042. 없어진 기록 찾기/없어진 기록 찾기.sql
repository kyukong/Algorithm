select outs.animal_id animal_id,
    outs.name name
from animal_ins ins
right join animal_outs outs
    on ins.animal_id = outs.animal_id
where ins.animal_id is null
order by outs.animal_id
;