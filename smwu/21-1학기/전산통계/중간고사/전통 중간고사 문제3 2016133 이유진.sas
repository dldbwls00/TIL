*경로 <C:＼Class＼전산통계> 밑에 저장되어 있는 원(시)자료 <Q3_rawdata.txt>를 불
러다가 아래와 같은 내용의 SAS 데이터셋 <one>을 임시라이브러리 work 밑에 생성/
저장한다. 단, fullname 이라는 새로운 변수도 추가로 생성/저장되도록 한다. ;
DATA one;
INFILE "C:\Class\전산통계\Q3_rawdata.txt" FIRSTOBS=5 OBS=8 EXPANDTABS;
INPUT lastname $1-4 firstname $ 5-12 gender $ 13-18 score 6.1 ;

fullname = compress(lastname || "," ) ||" " || firstname;


*위 작업 (1)에서 생성된 SAS 데이터셋 <one>을 변수 score 값 기준, 내림차순으로
정렬시킨다. ;
PROC SORT;
BY DESCENDING score;

* 위 작업(2)에서 생성된 SAS 데이터셋을 이용하여 임시라이브러리 work 밑에 변수
gender 값이 ‘Male’인 관측치들만 포함된 SAS 데이터셋 <two>를 생성/저장하되 3개
변수들(gender, score, fullname)만 포함시키도록 한다. 또한 출력창에 아래와 같은
내용이 PUT되도록 한다. ;

DATA two(keep=gender score fullname);
set one;
if gender="Male" then output two;

data _NULL_;
set two;
file print;
if _N_=1 then put
@21 30*"*" 
/@29 "Male인 관측치들"
/@21 30*"*"
/@21 "<Fullname>    <Score>   <순위>";
PUT @21 fullname @36 score 6.2 @46 _N_"등";
run;
