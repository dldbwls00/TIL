/* HW2  [����3] */

** ���� ä��� ;
** �� ���� gender ���� ;
** <Female>, <Male> �����ͼµ� ���� ;
DATA female male;
	************* ���� ä��� *************** ;
	infile datalines firstobs=2;
	INPUT jumin_num $14. city $ age;


	/********* (�� ����) SELECT ����  ********/
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
�� ������ ���� ���������Դϴ�. 
990505-2064581 Seoul 22 
981201-1581584 Seoul 23 
971010-2047815 Busan 24 
     .        Seoul 21 
990815-1285425 Kwangjoo 22 
991005-1154124 Daegu 22 
RUN;
