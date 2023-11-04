/* HW2  [문제3] */

** 문장 채우기 ;
** 새 변수 gender 생성 ;
** <Female>, <Male> 데이터셋들 생성 ;
DATA female male;
	************* 문장 채우기 *************** ;
	infile datalines firstobs=2;
	INPUT jumin_num $14. city $ age;


	/********* (한 개의) SELECT 구문  ********/
	select (substr(jumin_num, 8,1));
		when (2)	do;
							gender='F';
							output female;
						end;
		when (1) do;
							gender='M';
							output male;
						end;
		otherwise;
	end;

	DATALINES;
본 문제를 위한 가상데이터입니다. 
990505-2064581 Seoul 22 
981201-1581584 Seoul 23 
971010-2047815 Busan 24 
     .        Seoul 21 
990815-1285425 Kwangjoo 22 
991005-1154124 Daegu 22 
RUN;
