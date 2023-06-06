data reg163;
infile 'C:\REGDATA\reg163.dat';
input x1 x2 y;
run;

proc reg data=reg163;
model y=x1 x2 / partial;
run;
/*
proc reg data=reg163;
model y=x2 x1 / partial;
run;
*/
