* 경로 <C:＼Class＼전산통계> 밑에 저장되어 있는 <전산통계.txt> 파일을 불러다가 아
래와 같은 내용의 SAS 데이터셋 <comput>을 임시라이브러리 work 밑에 생성/저장
한다. 단, 변수들 major, id, ave_comput, axam1, exam2, exam3 순서대로 입력하
되 ave_comput 변수값은 (소숫점 3번 째 자리에서 반올림하여) 소숫점 2번 째 자리
까지만 기억되도록 한다. 또한 다음과 같은 새로운 변수 2개(course, grade)를 추가
생성되도록 한다. ;
DATA comput;
INFILE "C:\Class\전산통계\전산통계.txt" FIRSTOBS=13 OBS=44 EXPANDTABS;
INPUT #2 major $ 1-14 #1 id $  #3 ave_comput 1-10 exam1 exam2 exam3 #4 ;

ave_comput = round(ave_comput, 0.01);
course = "전산통계";
IF substr(id, 1, 2)="20" then grade="2학년";
else if substr(id, 1, 2)="19" then grade="3학년";

*<회귀분석_점수.txt>와 <회귀분석_전공.txt>를 한 개로 합하여 임시라이브러리 work
밑에 아래와 같은 SAS 데이터셋 <reg>을 생성/저장한다.;

DATA a1;
INFILE  "C:\Class\전산통계\회귀분석_점수.txt"  FIRSTOBS=8 OBS=25 EXPANDTABS;
INPUT id $ #2 ave_reg;
PROC SORT;
BY id;
DATA a2;
INFILE "C:\Class\전산통계\회귀분석_전공.txt" FIRSTOBS=9 OBS=26 EXPANDTABS;
INPUT id $ #2 major $ 1-14;
PROC SORT;
BY id;
DATA reg;
MERGE a2 a1;

*) 위 작업 (1)과 (2)에서 각각 생성된 SAS 데이터셋 <comput>과 <reg>을 합하여 임시
라이브러리 work 밑에 SAS 데이터셋 <all>을 생성/저장하되 변수들 major, id,
ave_comput, grade, ave_reg 만 저장되도록 한다. 참고로, 전산통계 과목도 수강하
면서 회귀분석 과목도 수강하는 학생(들)도 존재한다. ;
proc sort data=comput;
by id;
DATA all (keep= major id ave_comput grade ave_reg);
merge reg comput;
by id;
run;

*위 작업 (3)에서 생성된 SAS 데이터셋 <all>을 이용하여 경로 <C:\calss\전산통계>
밑에 다음과 같이 두 개의 SAS 데이터셋 <one>과 <two>를 생성/저장한다. SAS 데이터셋 <one>에는 전산통계 과목과 회귀분석 과목 중 한 과목만 수강하는 학
생(들)만 포함시키되 5개 변수들(id, major, grade, ave_comput, ave_reg)만 저장되
도록 한다. SAS 데이터셋 <two>에는 전산통계 과목과 회귀분석 과목 둘다 수강하는
학생(들)만 포함시키되 4개 변수들(id, major, grade, ave)만 저장되도록 한다. 단, 이
작업은 한 개의 DATA 단계에서 작업을 하여야 한다. ;

LIBNAME mydata "C:\Class\전산통계";
DATA mydata.one(keep=id major grade ave_comput ave_reg) mydata.two (keep=id major grade ave);
set all;

ave = MEAN(ave_comput, ave_reg);
IF (ave_reg = .) or (ave_comput = .) then output mydata.one;
else if  (ave_reg ~= .) or (ave_comput ~= .) then output mydata.two;
RUN;
