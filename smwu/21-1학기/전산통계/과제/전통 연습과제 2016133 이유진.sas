DATA one;
INPUT name $ 1-20 id gender $ exam1 exam2 exam3;
DATALINES;
KilDong             1 Male 89 95 75
YoungHee            2 Male 85 90 85
RUN;
PROC PRINT;
RUN;
LIBNAME mydata "C:\Class\�������";
DATA mydata.two;
INPUT name $ 1-20 id gender $ exam1 exam2 exam3;
DATALINES;
CheolSoo            4 F 89 90 85
MeeMee              3 Female 78 95 100
AMooGae             5 F 85 80 65
RUN;
PROC SORT;
by id;
RUN;
PROC PRINT;
RUN:
DATA mydata.three;
SET mydata.two;
average=(exam1+exam2+exam3)/3;
IF average<90 THEN grade='���հ�';
ELSE grade='�հ�';
RUN;
PROC PRINT;
RUN;
