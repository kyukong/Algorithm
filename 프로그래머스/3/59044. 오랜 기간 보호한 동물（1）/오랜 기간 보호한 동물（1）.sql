SELECT NAME, DATETIME
FROM (
    SELECT ROWNUM RN, NAME, DATETIME
    FROM (
        SELECT INS.ANIMAL_ID, INS.NAME, INS.DATETIME
        FROM ANIMAL_INS INS
        LEFT JOIN ANIMAL_OUTS OUTS
            ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
        WHERE OUTS.DATETIME IS NULL
        ORDER BY INS.DATETIME))
WHERE RN <= 3
;