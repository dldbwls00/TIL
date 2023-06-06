data reg165;
infile 'C:\REGDATA\reg165.dat';
input x1 x2 y;
run;

proc reg data=reg165;
model y=x1;
run;

proc gplot data=reg165;
plot y*x1;
run;
