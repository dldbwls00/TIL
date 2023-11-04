* OPTIONS NOTES SOURCE LS=80 NODATE NONUMBER FORMDLIM='*';

* OPTIONS NOTES SOURCE NODATE NONUMBER FORMDLIM='*';

* OPTIONS LS=80 FORMDLIM='*';

*---------------------------------;
* [노트03] 노트 p.1 ~      -------;
*---------------------------------;

 LIBNAME mine "G:\SM\전산통계_2020_12";

DATA students;    
		* DATA work.students;
		* DATA mine.students; 
	INPUT name $ 1-20 id_num sex $ dept $ exam1 exam2 exam3;
		* INPUT name $ id_num sex $ dept $ exam1 exam2 exam3; 
	DATALINES;
Sung Min Young      2005 f stat 30 30 40 
Sung Min Ji         2009 f cs   30 30 40 
Hong Gil Dong       1750 m math 29 28 27 
Kong Jui            1810 f cs   20 20 30 
Pat Jui             1808 f stat  5 10 15 
Yun Heung Boo       1670 m math  0 10  5 
Yun Nol Boo         1665 m cs   20 30 10 
Sun Nyeo            0300 f stat 25 25 35 
Shim Chung          1880 f math 29 28 27 
RUN;

PROC PRINT DATA=students;
* PROC PRINT DATA=work.students;
* PROC PRINT;
RUN; 

PROC SORT DATA=students;
	 BY id_num;
		* [참고] 숫자변수 오름차순 위계는 <결측, 음수, 0, 양수> 순;
		* 디폴트는 ascending(오름차순);
RUN;
/* 
PROC PRINT;
RUN;
*/

DATA credit / debug;
	SET students;
	score=exam1+exam2+exam3;
	IF score >= 50 THEN credit='Pass';
	               ELSE credit='Fail';
RUN;

PROC PRINT DATA=credit;
RUN;


*---------------------------------;
* [노트03] 노트 p.8        -------;
*---------------------------------;

DATA p8;
	INPUT x $;
	DATALINES;
abcdefghijklmn              
김수한무거북이와두루미
1234567890                   
RUN;
PROC PRINT;
RUN;

DATA p8;
	* INPUT x $20.;   
	INPUT x $ 1-20;
	DATALINES;
abcdefghijklmn      
김수한무거북이와두루미
1234567890           
RUN;
PROC PRINT DATA=p8;
RUN;


*---------------------------------;
* [노트03] 노트 p.9        -------;
*---------------------------------;

DATA p9;
	INPUT name $ exam1 exam2 exam3 exam4 exam5;	
	* INPUT name $ exam1-exam5;
	DATALINES; 
		Lee 17 16 19 20 15
		Kim 20 19 18 18 19
RUN;
PROC PRINT;
RUN;	

DATA p99;
	INPUT name $ weight height bust waist hip;
	DATALINES;
		Lee 55 165 34 26 34
		Kim 50 163 33 25 33
RUN;
PROC PRINT;
	VAR weight height bust waist hip;
	* VAR weight--hip;
RUN;

PROC CONTENTS DATA=credit VARNUM;
* PROC CONTENTS DATA=credit;
RUN; 


*---------------------------------;
* [노트03] 노트 p.10       -------;
*---------------------------------;

DATA p10;
	xk=3;  y=7;  xa=2;
RUN;
PROC PRINT;
	VAR x: ;
	* VAR xk xa;
RUN;

PROC PRINT DATA=credit;
	VAR e: ;
	* VAR exam1 exam2 exam3;
RUN;

PROC PRINT DATA=credit;
	VAR _numeric_;
	* VAR _character_;
	* VAR _all_;
RUN;

