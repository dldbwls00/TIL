/* �⸻ [����4] */

** (1) **;
libname out "C:\Class";
filename raw "C:\Class\�������" ;
DATA out.Q4;
	today=22446;  ** 2021�� 6�� 15���� ��¥�� �Է�/ó���� ��;
	INFILE raw(Q4.txt) FIRSTOBS=11 OBS=17;


** ������ ����� ä���/�ϼ��ϱ� **;
input class $3. no $3. birth $10. name $10. math 7. eng 5. sci 7.;
do;
	total+math;
	total+eng;
	total+sci;
	ave=round(total/3, 0.001);
	total=0;
end;
birth=input(birth, YYMMDD10.);
age=int((today-birth)/365)||"��";
drop today total;
RUN;

** (2) **;

** ���⿡ �۾� (2) �κ� ���� ���α׷� �ۼ� (�� ���� �ܰ�(step)) **;

proc rank data=out.Q4(drop=birth math eng sci) out=out.Q4_final descending ties=low;
var ave;
label rank="���� ave�� ����";
ranks rank;
format ave 5.2;
run;
