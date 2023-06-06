data reg163;
infile 'C:\REGDATA\reg163.dat';
input x1 x2 y;
run;

proc reg data=reg163;
model y=x1 x2 / SS1;
run;

proc reg data=reg163;
model y=x2 x1 / SS1;
run;

