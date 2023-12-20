select dr_name, dr_id, mcdp_cd, to_char(hire_ymd, 'YYYY-MM-DD') hire_ymd
from doctor
where mcdp_cd = 'CS' or mcdp_cd = 'GS'
order by hire_ymd desc, dr_name
;