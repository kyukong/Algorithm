select hours.hour,
    nvl(count, 0) count
from (
    select hour, count(*) count
    from (
        select extract(hour from cast(datetime as timestamp)) hour
        from animal_outs)
    group by hour
    order by hour) animal
right join (
    select level - 1 hour
    from dual
    connect by level <= 24) hours
    on hours.hour = animal.hour
order by hours.hour
;