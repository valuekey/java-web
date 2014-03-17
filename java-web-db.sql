SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE emp;
DROP TABLE dept;




/* Create Tables */

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
	photo varchar(100),
	PRIMARY KEY (empno)
);


CREATE TABLE dept
(
	deptno int(2) NOT NULL,
	dname varchar(14),
	loc varchar(13),
	PRIMARY KEY (deptno)
);



/* Create Foreign Keys */

ALTER TABLE emp
	ADD FOREIGN KEY (deptno)
	REFERENCES dept (deptno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



