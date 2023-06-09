-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, 
CONCAT_WS(" ", CITY, STREET_ADDRESS1, STREET_ADDRESS2),
concat_ws("-", substring(TLNO, 1, 3),substring(TLNO, 4, 4), substring(TLNO, 8, 4)) AS '전화번호'
FROM USED_GOODS_BOARD
JOIN USED_GOODS_USER
ON WRITER_ID=USER_ID
GROUP BY WRITER_ID
HAVING COUNT(BOARD_ID) >= 3
ORDER BY WRITER_ID DESC;