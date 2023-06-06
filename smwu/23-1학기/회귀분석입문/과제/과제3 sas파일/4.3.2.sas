data reg165;
infile 'C:\REGDATA\reg165.dat';
input x1 x2 y;
run;

proc reg data=reg165;
model y=x1 x2 / SS1;
run;

proc reg data=reg165;
model y=x2 x1 / SS1;
run;
