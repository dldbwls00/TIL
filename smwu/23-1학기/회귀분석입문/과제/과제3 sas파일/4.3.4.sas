data reg165;
infile 'C:\REGDATA\reg165.dat';
input x1 x2 y;
run;

proc gplot data=reg165;
plot x1*x2;
run;
