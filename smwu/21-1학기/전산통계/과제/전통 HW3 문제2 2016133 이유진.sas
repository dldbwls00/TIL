* 문제2 (1);
libname class "C:\Class";
data class.male(drop=female_count) class.all(drop=male_total male_ave);
set "C:\Class\전산통계\hw3_q2_rawdata";

if gender="여" then link modify;
	if gender="남" then do;
		male_count+1;
		male_total+score;
		male_ave=round(male_total/male_count, 0.001);
		retain;
		output class.male;
		end;
	output class.all;
return;

modify:
female_count+1;
run;

*(2);
ods pdf file="C:\Class\Male.pdf";
proc print data=class.male lable;
title 'Gender(성별)="남"인 경우만 모아놓은 데이터셋';
run;
ods pdf close;
