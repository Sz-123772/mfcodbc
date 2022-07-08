show tables;<br>
<br>
**用户表**<br>
create table Users(<br>
    user_id varchar(20) primary key,<br>
    user_password varchar(20),<br>
    user_remark varchar(20)<br>
) ;<br>
insert into Users values ('root', 'admin','root');<br>
drop table Users;<br>
<br>
**学生表**<br>
create table Students(<br>
    student_id varchar(20) primary key,<br>
    student_name varchar(20),<br>
    student_sex varchar(10),<br>
    student_age int,<br>
    student_major varchar(20),<br>
    student_class int<br>
) ;<br>
select * from students;<br>
drop table Students;<br>
<br>
**教师表**<br>
create table Teachers(<br>
    teacher_id varchar(20) primary key,<br>
    teacher_name varchar(20),<br>
    teacher_sex varchar(10),<br>
    teacher_age int,<br>
    teacher_title varchar(20)<br>
) ;<br>
drop table Teachers;<br>
select * from Teachers;<br>
<br>
**课程表**<br>
create table Courses(<br>
   course_id varchar(20) primary key,<br>
   course_name varchar(20),<br>
   course_credit double,<br>
   course_term int<br>
) ;<br>
drop table Courses;<br>
select * from Courses;<br>
<br>
**学习关系表**<br>
create table Study(<br>
    student_id varchar(20),<br>
    course_id varchar(20),<br>
    course_score int,<br>
    foreign key (student_id) references Students(student_id),<br>
    foreign key (course_id) references Courses(course_id)<br>
) ;<br>
drop table Study;<br>
select * from Study;<br>
<br>
**教授关系表**<br>
create table Teach(<br>
   teacher_id varchar(20),<br>
   course_id varchar(20),<br>
   foreign key (teacher_id) references Teachers(teacher_id),<br>
   foreign key (course_id) references Courses(course_id)<br>
) ;<br>
drop table Teach;<br>
select * from Teach;<br>