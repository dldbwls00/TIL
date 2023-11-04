* ����3 (1);
libname class "C:\Class";
data class.rawdata;
infile "C:\Class\�������\Q3.txt" firstobs=9 obs=13;
input id name $15. @28 deposit $12. rate percent. period;
deposit=int(compress(deposit, ","));
run;

* ����3 (2);
data class.result;
set class.sub; **[����3]_sub.sas;
run;

* ����3 (3);
data class.final;
set class.result;
by id;
format cum_year_interest cum_total yen20.2;

if first.id then cnt=0; **������ �͸� ��Ÿ���� ���� �ӽ� ����;
cnt+1;
if last.id;
keep id name cum_year_interest cum_total;
run;

* ����3 (4);
ods pdf file="C:\Class\final.pdf";
proc print data=class.final split="*"  label;
title1 "��ġ�� ������ �� �б� ������ �����ؼ� ����� ���� ���� �� ���"; 
title2 "(������ ���ݾ�, ������, ���� �� ���� �ٸ�)";
label cum_year_interest="����� ���� �� ���ھ� * (�� �б� ������ ����)";
label cum_total="����� ���� �Ѿ� * (����+����)";
run;
ods pdf close;
