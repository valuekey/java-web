SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE emp;
DROP TABLE dept;
DROP TABLE user;
DROP TABLE member;




/* Create Tables */

CREATE TABLE dept
(
	deptno int(2) NOT NULL,
	dname varchar(14),
	loc varchar(13),
	PRIMARY KEY (deptno)
);


CREATE TABLE emp
(
	empno int(4) NOT NULL,
	ename varchar(10),
	job varchar(9),
	hiredate date,
	sal float(7,2),
	comm float(7,2),
	mgr int(4),
	deptno int(2) NOT NULL,
	photo varchar(500),
	PRIMARY KEY (empno)
);


CREATE TABLE user
(
	userid varchar(30) NOT NULL,
	name varchar(30),
	password varchar(32),
	PRIMARY KEY (userid)
);


CREATE TABLE member
(
	mid varchar(50) NOT NULL,
	password varchar(32),
	name varchar(30),
	address varchar(200),
	telephone varchar(100),
	zipcode varchar(6),
	lastdate date,
	lockflag boolean,
	PRIMARY KEY (mid)
);



/* Create Foreign Keys */

ALTER TABLE emp
	ADD FOREIGN KEY (deptno)
	REFERENCES dept (deptno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



