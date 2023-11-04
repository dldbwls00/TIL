*경로 <C:＼Class＼전산통계> 밑에 저장되어 있는 원(시)자료 <HW1_Q2_rawdata.txt>
를 불러다가 아래와 같은 내용의 SAS 데이터셋 <three>를 임시라이브러리 work 밑
에 생성/저장한다. 단, 이 데이터셋에 변수들은 status, id, major, class, course 순
서대로 생성되도록 작업한다. 또한 class 라는 변수값이 “02”이면서 major 라는 변수
값이 “Stat”인 관측치들에 대한 모든 변수값들을 출력창에 PUT되도록 한다.;
LIBNAME mydata "C:\Class\전산통계";
DATA work.three;
INFILE "C:\Class\전산통계\HW1_Q2_rawdata.txt" FIRSTOBS=13 OBS=30;
INPUT #1 status $ 1;
IF status='S' THEN INPUT #1 @3 id #2 @12 major $ @10 class $ @1 course $  #3;
ELSE IF status='P' THEN INPUT #2 course $ #3;

FILE PRINT;
IF class="02" AND major="Stat" THEN PUT status $ id major $ class $ course $;
RUN;
* 위 작업 (1)에서 생성된 SAS 데이터셋 <three>를 경로 <C:＼Class＼전산통계> 밑에 <finaldata.txt>라는 텍스트 파일로 내보내도록 한다.
이 작업 부분에 대한 실제 SAS 프로그램 내용도 제출하는 프로그램내에, 필요한 위치에 포함시켜서 제출하도록 한다. ;
PROC EXPORT DATA= WORK.THREE 
            OUTFILE= "C:\Class\전산통계\finaldata.txt" 
            DBMS=TAB REPLACE;
     PUTNAMES=YES;
RUN;
