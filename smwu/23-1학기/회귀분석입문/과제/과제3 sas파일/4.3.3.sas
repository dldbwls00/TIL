data reg165;
infile 'C:\REGDATA\reg165.dat';
input x1 x2 y;
run;

proc reg data=reg165;
model y=x1 x2 / partial;
run;

proc reg data=reg165;
model y=x2 x1 / partial;
run;
