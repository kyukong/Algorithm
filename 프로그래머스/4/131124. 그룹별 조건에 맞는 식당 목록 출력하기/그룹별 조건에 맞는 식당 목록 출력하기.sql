select profile.member_name member_name,
    review.review_text review_text,
    to_char(review.review_date, 'YYYY-MM-DD') review_date
from member_profile profile
join rest_review review
    on profile.member_id = review.member_id
where profile.member_id in (
    select member_id
    from (
        select member_id, count(*) total
        from rest_review
        group by member_id)
    where total = (
        select max(total) max_total
        from (
            select member_id, count(*) total
            from rest_review
            group by member_id)))
order by review.review_date, review.review_text
;