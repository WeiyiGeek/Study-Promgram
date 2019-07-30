create table user(
	id int not null auto_increment,
	username varchar(50) not null default '',
	password char(32) not null default '',
	email varchar(80) not null default '',
	allow_1 smallint not null default 0,
	allow_2 smallint not null default 0,
	allow_3 smallint not null default 0,
	primary key(id)
);
