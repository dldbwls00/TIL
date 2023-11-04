* 문제2 (1);
libname class "C:\Class";
data class.Q2_all;
infile "C:\Class\전산통계\Q2_salary.txt" firstobs=6 obs=13 dlm=",\"; 
input id salary;
run;
proc sort;
by id;
run;
data dept;
infile "C:\Class\전산통계\Q2_sinsang.txt" firstobs=7 obs=14 dsd;
input dept $15. @26 date YYMMDD10.;
dept=compress(dept, ',');
run;
data goal;
infile "C:\Class\전산통계\Q2_goal.txt" firstobs=14 obs=21 dsd;
input id qtr4 qtr1 qtr2 qtr3 goal_qtr4 goal_qtr1 goal_qtr2 goal_qtr3 today DATE9. ;
run;
data class.Q2_all;
merge  class.Q2_all dept goal;
run;

* 문제2 (2);
data class.Q2_final;
set class.Q2_all;
format date MMDDYY8.;

dates=today-date;
if dates/365>8 then dates=8;
else if dates/365>7 then dates=7;
else if dates/365>6 then dates=6;
else if dates/365>5 then dates=5;
else;

workingyears=dates||"년 이상 근속";
array qtr{*} qtr4 qtr1 qtr2  qtr3;
array goal{*} goal_qtr4 goal_qtr1 goal_qtr2 goal_qtr3;
array bonus{*} bonus1 bonus2 bonus3 bonus4;

format bonus1-bonus4 year_bonus year_total dollar20.;

do i=1 to 4;
	if qtr{i}>=2*goal{i} then bonus{i}=salary*3;
	else if qtr{i}>=goal{i} and qtr{i}<2*goal{i} then bonus{i}=salary*2;
	else if qtr{i}>=0.5*goal{i} and qtr{i}<goal{i} then bonus{i}=salary*1;
	else bonus{i}=0;
end;

year_bonus=sum(bonus1+bonus2+bonus3+bonus4);
year_total=year_bonus+salary*12;

keep id dept date workingyears bonus1-bonus4 year_bonus year_total;
run;
  
* 문제2 (3);
proc sort data=class.Q2_final out=work.Q2_temp;
by descending dept;
run;

data class.Q2_ByDept;
set work.Q2_temp;
by descending dept;
format dept_bonus dept_total dollar20.;

if first.dept then do; dept_bonus=0; dept_total=0; end;
dept_bonus+year_bonus;
dept_total+year_total;
if last.dept;

keep dept dept_bonus dept_total;
run;
