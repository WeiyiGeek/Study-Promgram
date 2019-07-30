/*
     session  (建议使用内存表)
    0.  记录用户uid              uid （索引）
    1.  记录session id           sid （主键）
    3.  session数据              sdata
    2.  修改时间                 utime
    4.  ip         用户IP        uip
    5.  user_agent 浏览器        uagent
*/

create table session(
    uid int not null default 0,
    sid varchar(255) not null default '',
    sdata text,
    utime int not null default 0,
    uip char(15) not null default '',
    uagent varchar(200) not null default '',
    primary key(sid),
	index session_sid(uid)
);