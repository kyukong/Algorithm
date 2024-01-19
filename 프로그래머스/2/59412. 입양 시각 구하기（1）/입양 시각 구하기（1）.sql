select extract(hour from cast(datetime as timestamp)) hour,
    count(*) count
from animal_outs
where extract(hour from cast(datetime as timestamp))
    between 9 and 19
group by extract(hour from cast(datetime as timestamp))
order by extract(hour from cast(datetime as timestamp))
;