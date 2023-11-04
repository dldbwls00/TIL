	*경로 <C:＼Class＼전산통계> 밑에 저장되어 있는 9개의 SAS 데이터셋 파일들을 이
용하여 임시라이브러리 work 밑에 3개의 SAS 데이터셋 <eng>, <math>, <sci>를 생
성/저장한다. ;
DATA eng;
SET "C:\Class\전산통계\eng_01" "C:\Class\전산통계\eng_02" "C:\Class\전산통계\eng_03";
DATA math;
SET "C:\Class\전산통계\math_01" "C:\Class\전산통계\math_02" "C:\Class\전산통계\math_03";
DATA sci;
SET "C:\Class\전산통계\sci_01" "C:\Class\전산통계\sci_02" "C:\Class\전산통계\sci_03";

*위 작업(1)에서 생성된 3개의 SAS 데이터셋들(<eng>, <math>, <sci>)을 이용하여
모든 반(1, 2, 3반) 학생들의 모든 시험(영어, 수학, 과학) 점수가 포함된 SAS 데이터
셋 <all>을 임시라이브러리 work 밑에 생성/저장한다. 또한 이 SAS 데이터셋 <all>에
는 새로운 변수 total도 추가로 생성하고 이 변수 total 값 기준으로, 내림차순으로 정
렬한다. ;
PROC SORT DATA=eng;
BY class no;
PROC SORT DATA=math;
BY class no;
PROC SORT DATA=sci;
BY class no;
DATA all;
MERGE eng math sci;
BY class no;
total = eng_score+math_score+sci_score;
PROC SORT DATA=all;
BY DESCENDING total;
RUN;
