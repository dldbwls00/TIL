*문제1 (1);
libname class "C:\Class";
data class.one;
set "C:\Class\전산통계\hw3_q1_rawdata";

if score=. then delete;
run;

*(2);
proc sort;
by name no;
run;

data class.two(drop=oldname oldno);
set class.one;

if (oldname=name) and (oldno=no) then delete;
oldname=name;
oldno=no;
retain oldname oldno;
run;

*(3);
proc sort;
by descending score;

data class.three;
set class.two;

rank=_N_ || "등";
label rank="시험 점수 기준 등수";
run;
