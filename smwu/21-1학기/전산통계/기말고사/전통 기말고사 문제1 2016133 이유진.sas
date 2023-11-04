/* �⸻ [����1] */

** (1) **;
LIBNAME mine "C:\Class";
DATA mine.Q1_1 mine.Q1_2 ;  
	

   ** ������ ����� ä���/�ϼ��ϱ� **;
infile datalines firstobs=5 missover;
input id $ test $ score1-score3;

if score3=. and score2=. then score=score1;
else if score3=. then score=score2;
else score=score3;

if test="1��" then output mine.Q1_1;
else output mine.Q1_2; 

drop score1 score2 score3;

	DATALINES;
�Ʒ� ������ �Է� ������, 
	id(�� ������ ���� ��ȣ), test(���� ��������(1�� �Ǵ� 2��)), score(���� ����), ......  
	��, score�� id ����, �� ������������  (���� �� ġ�� ��찡 �����Ƿ�) ���� �� ���� �� ���� 
	�� ���������� ������ score(��������)�� �����ͼ����� ���������� �Ѵ�.
01 1�� 50 60 73  
01 2�� 82  
02 1�� 85 
02 2�� 55 71 
03 1�� 56 60 69 
04 1�� 80 
04 2�� 67  
05 1�� 68 69 
RUN;

** (2) **;

** ���⿡ �۾� (2) �κ� ���� ���α׷� �ۼ� **;
data mine.Q1_all;
merge mine.Q1_1 (rename=(score=score_1st)) mine.Q1_2  (rename=(score=score_2nd));
by id;

if score_2nd >= 70 then status="�����հ�";
drop test score;
run;
