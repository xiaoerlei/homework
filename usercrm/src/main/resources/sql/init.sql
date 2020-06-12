create table t_user(
	id VARCHAR(40) PRIMARY KEY,
	username VARCHAR(40),
	nickname VARCHAR(40),
	password VARCHAR(60),
	tel VARCHAR(20),
	sex VARCHAR(4)
);

create table t_emp(
	id INT(11) PRIMARY KEY,
	name VARCHAR(40),
	salary DOUBLE(7,2),
	age INT(3)
);

create table t_lottery(
	id INT(11) PRIMARY KEY,
	name VARCHAR(40),
	reward_type INT(2)
);

