select mcdp_cd "진료과코드", apnt_count "5월예약건수"
from (
    select mcdp_cd, count(*) apnt_count
    from appointment
    where to_char(apnt_ymd, 'YYYY-MM') = '2022-05'
    group by mcdp_cd)
order by apnt_count, mcdp_cd
;