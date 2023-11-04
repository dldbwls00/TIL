* OPTIONS NONOTES NOSOURCE LS=80 nodate nonumber;

* OPTIONS NOTES SOURCE LS=80 nodate nonumber FORMDLIM='*';

* OPTIONS LS=78;  options nodate;

*---------------------------------;
* [노트02] 노트 p.2 & p.10 -------;
*---------------------------------;

DATA students;
	INPUT name $ 1-20 id_num sex $ dept $ exam1 exam2 exam3;
	DATALINES;
    Sung Min Young     2005 f stat 30 30 40
    Sung Min Ji        2009 f cs   30 30 40
    Hong Gil Dong      1750 m math 29 28 27
	Kong Jui           1810 f cs   20 20 30
	Pat Jui            1808 f stat  5 10 15
	Yun Heung Boo      1670 m math  0 10  5
	Yun Nol Boo        1665 m cs   20 30 10
	Sun Nyeo           0300 f stat 25 25 35
	Shim Chung         1880 f math 29 28 27  
RUN;

PROC PRINT DATA=students;
RUN; 

PROC SORT DATA=students;
	BY id_num;
RUN;

DATA credit;
	SET students;
	score=exam1+exam2+exam3;
	IF score >= 50 THEN credit='Pass';
	               ELSE credit='Fail';
RUN;

PROC PRINT DATA=credit;
RUN;


*---------------------------------;
* [노트02] 노트 p.14 -------------;
*          ! (브레이크 아이콘)    ;
*---------------------------------;
/*
DATA test;
	k=1;
	DO WHILE(k>0);
		k=k+1;
	END;
RUN;
