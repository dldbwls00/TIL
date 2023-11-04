/* 기말 [문제4] */

** (1) **;
libname out "C:\Class";
filename raw "C:\Class\전산통계" ;
DATA out.Q4;
	today=22446;  ** 2021년 6월 15일을 날짜로 입력/처리한 값;
	INFILE raw(Q4.txt) FIRSTOBS=11 OBS=17;


** 누락된 문장들 채우기/완성하기 **;
input class $3. no $3. birth $10. name $10. math 7. eng 5. sci 7.;
do;
	total+math;
	total+eng;
	total+sci;
	ave=round(total/3, 0.001);
	total=0;
end;
birth=input(birth, YYMMDD10.);
age=int((today-birth)/365)||"세";
drop today total;
RUN;

** (2) **;

** 여기에 작업 (2) 부분 관련 프로그램 작성 (한 개의 단계(step)) **;

proc rank data=out.Q4(drop=birth math eng sci) out=out.Q4_final descending ties=low;
var ave;
label rank="변수 ave의 순위";
ranks rank;
format ave 5.2;
run;
