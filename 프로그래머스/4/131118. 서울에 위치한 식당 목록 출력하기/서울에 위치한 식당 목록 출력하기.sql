-- 반올림 시 나머지 자리 0으로 채우기
select 
    info.rest_id rest_id,
    info.rest_name rest_name,
    info.food_type food_type,
    info.favorites favorites,
    info.address address,
    round(avg(review.review_score), 2) score
from rest_info info
join rest_review review
on info.rest_id = review.rest_id
where info.address like '서울%'
group by info.rest_id, info.rest_name, info.food_type, info.favorites, info.address
order by score desc, favorites desc
;