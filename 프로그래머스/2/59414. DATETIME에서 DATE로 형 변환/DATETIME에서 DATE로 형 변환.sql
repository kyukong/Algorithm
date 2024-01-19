select animal_id, name, to_char(datetime, 'YYYY-MM-DD') datetime
from animal_ins
order by animal_id
;