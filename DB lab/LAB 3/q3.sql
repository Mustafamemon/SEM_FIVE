DROP table faculty;
DROP table Department;


CREATE table faculty
(
Faculty_ID NUMBER(6) ,
Last_Name VARCHAR2(15) NOT NULL ,
First_Name VARCHAR2(15) NOT NULL,
Dept CHAR(3),
CONSTRAINT faculty_pk PRIMARY KEY (Faculty_ID)
);
CREATE table Department
(
Dept_Code CHAR(3),
Dept_Name VARCHAR2(20)NOT NULL,
CONSTRAINT dept_pk PRIMARY KEY (Dept_Code)

);
ALTER table Department
ADD Location CHAR(7);
