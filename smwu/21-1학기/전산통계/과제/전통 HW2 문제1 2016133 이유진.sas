* 문제1;
libname mydata "C:\Class\전산통계";
data mydata.statmath12 (DROP=gender grade name lastname)
mydata.statmath34 (DROP=gender grade name lastname)
mydata.other12 (DROP=gender grade name lastname)
mydata.other34 (DROP=gender grade name lastname)
mydata.nomajor (DROP=major name lastname);

set mydata.hw2_q1_rawdata;

fullname = trim(name) || " " || lastname;

if (major="stat" or major="math") and (grade=1 or grade=2) 
	then	do;
				status="stat/math & 1/2";
				output mydata.statmath12;
			end;
else if (major="stat" or major="math") and (grade=3 or grade=4)
	then 	do;
				status="stat/math & 3/4";
				output mydata.statmath34;
			end;
else if (major="eco" or major="law" or major="edu" or major="phy") and (grade=1 or grade=2)
	then	do;
				status="other & 1/2";
				output mydata.other12;
			end;
else if (major="eco" or major="law" or major="edu" or major="phy") and (grade=3 or grade=4) 
	then do;
				status="other & 3/4";
				output mydata.other34;
			end;
else	do;
			status="무전공";
			output mydata.nomajor;
		end;

run;
