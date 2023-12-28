select 
    a.apnt_no apnt_no,
    p.pt_name pt_name,
    p.pt_no pt_no,
    a.mcdp_cd mcdp_cd,
    d.dr_name dr_name,
    apnt_ymd
from appointment a
join patient p
    on p.pt_no = a.pt_no
join doctor d
    on a.mddr_id = d.dr_id
where to_char(a.apnt_ymd, 'YYYY-MM-DD') = '2022-04-13'
    and a.apnt_cncl_yn = 'N'
    and d.mcdp_cd = 'CS'
order by a.apnt_ymd
;