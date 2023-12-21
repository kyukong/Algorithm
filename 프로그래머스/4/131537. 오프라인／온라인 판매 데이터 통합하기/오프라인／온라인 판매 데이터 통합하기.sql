-- 조건 : 2022 년 3 월 오프라인/온라인 상품 판매 데이터
-- 데이터 : 판매 날짜, 상품 아이디, 유저 아이디, 판매량
-- 데이터 : 오프라인은 user_id null 로 표시
-- 정렬 : 판매일 오름차순, 상품 아이디 오름차순, 유저 아이디 오름차순

select
    to_char(sales_date, 'YYYY-MM-DD') sales_date,
    product_id,
    user_id,
    sales_amount
from (
    select sales_date, product_id, user_id, sales_amount
    from online_sale
    union
    select sales_date, product_id, null user_id, sales_amount
    from offline_sale)
where to_char(sales_date, 'YYYY-MM') = '2022-03'
order by sales_date, product_id, user_id
;