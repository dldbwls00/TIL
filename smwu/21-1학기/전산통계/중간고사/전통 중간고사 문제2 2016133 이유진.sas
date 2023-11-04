/* 중간시험 과제물 [문제2] */

** 누락된 문장들 완성하여 SAS 데이터셋 <one>, <two> 내용 나오도록 ;
** 이 문장들 채워서 저장하여 이 프로그램 파일([문제2].sas) 그대로 제출;

 * 이 부분에 누락된 문장 채우기;
DATA one(drop=double) two(drop=sq);
	DO i=1 TO 10 BY 1 ; 
            * 이 부분에 누락된 문장들(3~4문장) 채우기;
	sq = i*i;
	OUTPUT one;
	double = i*2;
	OUTPUT two;

	END;
RUN;
