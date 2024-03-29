SELECT CAR.CAR_ID, CAR.CAR_TYPE, 
    CAR.DAILY_FEE * 30 * ((100 - PLAN.DISCOUNT_RATE) / 100) FEE
FROM CAR_RENTAL_COMPANY_CAR CAR
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN PLAN
    ON CAR.CAR_TYPE = PLAN.CAR_TYPE
WHERE CAR.CAR_TYPE IN ('세단', 'SUV')
    AND CAR.CAR_ID NOT IN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE TO_CHAR(START_DATE, 'YYYY-MM-DD') BETWEEN '2022-11-01' AND '2022-11-30'
            OR TO_CHAR(END_DATE, 'YYYY-MM-DD') BETWEEN '2022-11-01' AND '2022-11-30'
            OR (TO_CHAR(START_DATE, 'YYYY-MM-DD') <= '2022-11-01'
                AND TO_CHAR(END_DATE, 'YYYY-MM-DD') >= '2022-11-30'))
    AND PLAN.DURATION_TYPE = '30일 이상'
    AND CAR.DAILY_FEE * 30 * ((100 - PLAN.DISCOUNT_RATE) / 100) >= 500000
    AND CAR.DAILY_FEE * 30 * ((100 - PLAN.DISCOUNT_RATE) / 100) < 2000000
ORDER BY FEE DESC, CAR.CAR_TYPE, CAR.CAR_ID DESC
;