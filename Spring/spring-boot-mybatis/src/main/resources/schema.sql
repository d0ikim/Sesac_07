-- 데이터베이스 생성
create database codingon default character set utf8 default collate utf8_general_ci;
use codingon;
drop table if exists codingon;

-- users 테이블 생성
drop table if exists users;
create table users(
    id bigint auto_increment primary key,
    username varchar(50) not null,
    email varchar(100) not null,
    created_at timestamp default current_timestamp
);

-- users 테이블에 더미 데이터 삽입
insert into users (username, email) values
    ('john_doe', 'john.doe@example.com'),
    ('jane_smith', 'jane.smith@example.com'),
    ('bob-johnson', 'bob.johnson@example.com');

select * from users;