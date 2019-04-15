create  database ebook;
use ebook;

create table book_brief
(
  name varchar(100),
  ISBN varchar(20),
  price numeric(10, 2),
  author varchar(100),
  inventory int,
  cover_path varchar(100),
  intro varchar(500),
  primary key (ISBN)
);

create table user
(
  name varchar(100),
  ID varchar(20),
  avatar_path varchar(100),
  password varchar(20),
  email varchar(30),
  state int,
  primary key (ID)
);

create table orders
(
  order_id varchar(20),
  ID varchar(20),
  ISBN varchar(20),
  time varchar(20),
  amount int,
  state int,
  primary key (order_id),
  foreign key (ID) references user(ID),
  foreign key (ISBN) references book_brief(ISBN)
);

alter table book_brief change name name varchar(100) character set utf8 collate utf8_unicode_ci not null default '';
alter table book_brief change author author varchar(100) character set utf8 collate utf8_unicode_ci not null default '';
alter table book_brief change intro intro varchar(500) character set utf8 collate utf8_unicode_ci not null default '';
alter table user change name name varchar(100) character set utf8 collate utf8_unicode_ci not null default '';

insert into book_brief
values
       (
        '《一号测试图书》FROM MYSQL',
        '19990622',
        99.99,
        'Developer',
        99,
        'http://101.132.73.215:3031/static/img/book6.27eae71.jpg',
        '一本测试用例书籍。'
        );

insert into book_brief
values
       (
        '《两号》FROM MYSQL',
        '19990611',
        89.99,
        'Developer',
        99,
        'http://101.132.73.215:3031/static/img/book8.1899685.jpg',
        '一本测试用例书籍。'
        );

insert into user
values
       (
        '头号读者',
        'reader#1',
        'https://i.loli.net/2017/08/21/599a521472424.jpg',
        '123456',
        '1471303664@qq.com',
        1
        );

insert into orders
values
       (
        '1',
        'reader#1',
        '19990622',
        '2019-04-11',
        2,
        1
        );