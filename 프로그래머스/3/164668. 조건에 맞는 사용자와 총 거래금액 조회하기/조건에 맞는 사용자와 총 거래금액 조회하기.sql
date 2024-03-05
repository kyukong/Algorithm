SELECT USER_ID, NICKNAME, TOTAL
FROM (
    SELECT WRITER_ID, SUM(PRICE) TOTAL
    FROM USED_GOODS_BOARD
    WHERE STATUS = 'DONE'
    GROUP BY WRITER_ID
    HAVING SUM(PRICE) >= 700000) BOARD
JOIN USED_GOODS_USER USERS
    ON BOARD.WRITER_ID = USERS.USER_ID
ORDER BY TOTAL
;