select hour, count(*) count
from (
    select 
        datetime, 
        extract(hour from cast(datetime as timestamp)) hour
    from animal_outs
    where extract(hour from cast(datetime as timestamp))
        between 9 and 19)
group by hour
order by hour
;