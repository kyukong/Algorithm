SELECT USER_ID, NICKNAME, 
    CITY || ' ' || STREET_ADDRESS1 || ' ' || STREET_ADDRESS2 "전체주소", 
    SUBSTR(TLNO, 1, 3) || '-' || SUBSTR(TLNO, 4, 4) || '-' || SUBSTR(TLNO, 8) "전화번호"
FROM (
    SELECT WRITER_ID, COUNT(*) COUNT
    FROM USED_GOODS_BOARD
    GROUP BY WRITER_ID
    HAVING COUNT(*) >= 3) BOARD
JOIN USED_GOODS_USER USERS
    ON BOARD.WRITER_ID = USERS.USER_ID
ORDER BY WRITER_ID DESC
;