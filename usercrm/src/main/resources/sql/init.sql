create table t_user(
	id VARCHAR(40) PRIMARY KEY,
	username VARCHAR(40),
	nickname VARCHAR(40),
	password VARCHAR(60),
	tel VARCHAR(40),
	sex VARCHAR(4)
);

create table t_emp(
	id VARCHAR(40) PRIMARY KEY,
	name VARCHAR(40),
	salary DOUBLE(7,2),
	age INT(3)
);


