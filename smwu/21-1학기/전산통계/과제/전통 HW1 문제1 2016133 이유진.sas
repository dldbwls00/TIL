**경로 <C:＼Class＼전산통계> 밑에 저장되어 있는 원(시)자료 <HW1_Q1_rawdata.txt>
를 불러다가 아래와 같은 내용의 SAS 데이터셋 <one>을 경로 <C:＼Class＼전산통
계> 밑에 생성/저장한다. ;
LIBNAME mydata "C:\Class\전산통계";
DATA mydata.one;
INFILE "C:\Class\전산통계\HW1_Q1_rawdata.txt" FIRSTOBS=11 OBS=14;
INPUT fullname $ 1-10 gender $ 11-17 exam1 18-20 exam2 21-23  exam3 24-26 exam4 27-29;
RUN;
*위 작업 (1)에서 생성된 SAS 데이터셋 <one>을 이용하여 다음과 같은 3개 변수들
(total, ave, grade)이 추가된 새로운 SAS 데이터셋 <two>를 임시라이브러리인 work
밑에 생성/저장한다. 단, 이 SAS 데이터셋 <two>에는 5개 변수들(fullname, gender,
total, ave, grade)만 포함되도록 한다. ;
DATA work.two(DROP=exam1 exam2 exam3 exam4);
SET mydata.one;
* 결측인 시험점수는 0점으로 간주하여 계산;
if exam3=. then exam3=0;
if exam4=. then exam4=0;
total=exam1+exam2+exam3+exam4;
ave=MEAN(exam1, exam2, exam3, exam4);
IF ave < 70 THEN grade="불합격";
		ELSE grade="합격";
RUN;
