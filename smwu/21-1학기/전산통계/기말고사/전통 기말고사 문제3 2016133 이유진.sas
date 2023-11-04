* 문제3 (1);
libname class "C:\Class";
data class.rawdata;
infile "C:\Class\전산통계\Q3.txt" firstobs=9 obs=13;
input id name $15. @28 deposit $12. rate percent. period;
deposit=int(compress(deposit, ","));
run;

* 문제3 (2);
data class.result;
set class.sub; **[문제3]_sub.sas;
run;

* 문제3 (3);
data class.final;
set class.result;
by id;
format cum_year_interest cum_total yen20.2;

if first.id then cnt=0; **마지막 것만 나타내기 위한 임시 변수;
cnt+1;
if last.id;
keep id name cum_year_interest cum_total;
run;

* 문제3 (4);
ods pdf file="C:\Class\final.pdf";
proc print data=class.final split="*"  label;
title1 "거치식 예금을 매 분기 복리로 정산해서 만기시 받을 이자 등 계산"; 
title2 "(고객마다 예금액, 연이율, 만기 등 각기 다름)";
label cum_year_interest="만기시 받을 총 이자액 * (매 분기 복리로 정산)";
label cum_total="만기시 받을 총액 * (원금+이자)";
run;
ods pdf close;
