*����1 (1);
libname class "C:\Class";
data class.one;
set "C:\Class\�������\hw3_q1_rawdata";

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

rank=_N_ || "��";
label rank="���� ���� ���� ���";
run;
