libname class "C:\Class";
data class.sub (keep=id name rate interest1 interest2 interest3 interest4 year year_interest cum_year_interest cum_total);
set class.rawdata;
format rate percent7.2;
array interest{*} interest1 interest2 interest3 interest4;
year=0;
format interest1-interest4 yearly_interest cum_year_interest cum_total quarterly yen20.2;
by id;

do i=1 to period;
	year+1;
	do j=1 to 4;
		quarterly+(quarterly+deposit)*rate/4;

		if j=4 then interest{j}=quarterly-(interest{3}+interest{2}+interest{1});
		else if j=3 then interest{j}=quarterly-(interest{2}+interest{1});
		else if j=2 then interest{j}=quarterly-interest{1};
		else if j=1 then interest{j}=quarterly;
	end;
	yearly_interest=interest{4}+interest{3}+interest{2}+interest{1};
	cum_year_interest+yearly_interest;
	cum_total=deposit+cum_year_interest;
	output;
	quarterly=quarterly-(interest{3}+interest{2}+interest{1});
 end;
 run;
