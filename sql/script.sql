CREATE schema purpledon;

-- 테이블 삭제
DROP TABLE IF EXISTS order_burger CASCADE;
DROP TABLE IF EXISTS order_set CASCADE;
DROP TABLE IF EXISTS order_member CASCADE;
DROP TABLE IF EXISTS order_list CASCADE;

-- 테이블 생성
-- category 테이블 생성

CREATE TABLE IF NOT EXISTS order_set
(
    order_code    INT AUTO_INCREMENT COMMENT '주문코드',
    drink_name    VARCHAR(30) COMMENT '음료명',
    side_name    VARCHAR(30) COMMENT '사이드명',
    PRIMARY KEY (order_code)
    ) ENGINE=INNODB COMMENT '주문세트';


CREATE TABLE IF NOT EXISTS order_member
(
    member_name  VARCHAR(30) NOT NULL COMMENT '회원명',
    phone    VARCHAR(30) COMMENT '전화번호',
    PRIMARY KEY (member_name)
    ) ENGINE=INNODB COMMENT '주문회원';

CREATE TABLE IF NOT EXISTS order_list
(
    order_code    INT AUTO_INCREMENT COMMENT '주문코드',
    original_price   INT NOT NULL COMMENT '원가',
    discount_rate    INT NOT NULL COMMENT '할인율',
    member_name    VARCHAR(30) NOT NULL COMMENT '회원명',
    final_price    INT NOT NULL COMMENT '결제금액',
    PRIMARY KEY (order_code),
    FOREIGN KEY (member_name) REFERENCES order_member (member_name)
    ) ENGINE=INNODB COMMENT '주문내역';

CREATE TABLE IF NOT EXISTS order_burger
(
    order_code   INT AUTO_INCREMENT COMMENT '주문코드',
    hamburger_name    VARCHAR(30) COMMENT '햄버거명',
    PRIMARY KEY (order_code),
    FOREIGN KEY (order_code) REFERENCES order_list (order_code)
    ) ENGINE=INNODB COMMENT '주문버거';

-- 데이터 삽입

SELECT * FROM order_set;


SELECT * FROM order_burger;

INSERT INTO order_member(member_name, phone) VALUES ('김정희', '01011112222');
INSERT INTO order_member(member_name, phone) VALUES ('이후영', '01055556666');
INSERT INTO order_member(member_name, phone) VALUES ('이수민', '01077778888');
INSERT INTO order_member(member_name, phone) VALUES ('우리조', '01099998888');
INSERT INTO order_member(member_name, phone) VALUES ('박수쳐', '01012345678');

SELECT * FROM order_member;

COMMIT;