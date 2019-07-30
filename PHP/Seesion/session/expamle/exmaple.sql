create table email(
    id int not null auto_increment,
    uid int not null default 0,
    title varchar(255) not null default '',
    ptime int not null default 0,
	content text,
    primary KEY (id)
);


insert into email(uid, title, ptime, content) values(1, '第一篇文章', 1335678933, '测试admin');
insert into email(uid, title, ptime, content) values(1, '我的梦想', 1335678933, '111admin111');
insert into email(uid, title, ptime, content) values(1, '我的邮件反馈', 1335678933, '111ad1111');
insert into email(uid, title, ptime, content) values(1, '完成上进心', 1335678933, '111111111');

insert into email(uid, title, ptime, content) values(2, 'aaa 测试邮件 aa', 1335678933, '111111111');
insert into email(uid, title, ptime, content) values(2, 'bbbbbbbbbbbbbbbbb', 1335678933, '111111111');
insert into email(uid, title, ptime, content) values(2, 'cccccccccccccccccc', 1335678933, '111111111');