/* 기말 [문제1] */

** (1) **;
LIBNAME mine "C:\Class";
DATA mine.Q1_1 mine.Q1_2 ;  
	

   ** 누락된 문장들 채우기/완성하기 **;
infile datalines firstobs=5 missover;
input id $ test $ score1-score3;

if score3=. and score2=. then score=score1;
else if score3=. then score=score2;
else score=score3;

if test="1차" then output mine.Q1_1;
else output mine.Q1_2; 

drop score1 score2 score3;

	DATALINES;
아래 변수들 입력 순서는, 
	id(각 관측의 고유 번호), test(몇차 시험인지(1차 또는 2차)), score(시험 점수), ......  
	단, score는 id 마다, 각 시험차수마다  (여러 번 치른 경우가 있으므로) 여러 개 있을 수 있음 
	각 시험차수의 마지막 score(시험점수)만 데이터셋으로 내보내고자 한다.
01 1차 50 60 73  
01 2차 82  
02 1차 85 
02 2차 55 71 
03 1차 56 60 69 
04 1차 80 
04 2차 67  
05 1차 68 69 
RUN;

** (2) **;

** 여기에 작업 (2) 부분 관련 프로그램 작성 **;
data mine.Q1_all;
merge mine.Q1_1 (rename=(score=score_1st)) mine.Q1_2  (rename=(score=score_2nd));
by id;

if score_2nd >= 70 then status="최종합격";
drop test score;
run;
