*��� <C:��Class���������> �ؿ� ����Ǿ� �ִ� ��(��)�ڷ� <Q3_rawdata.txt>�� ��
���ٰ� �Ʒ��� ���� ������ SAS �����ͼ� <one>�� �ӽö��̺귯�� work �ؿ� ����/
�����Ѵ�. ��, fullname �̶�� ���ο� ������ �߰��� ����/����ǵ��� �Ѵ�. ;
DATA one;
INFILE "C:\Class\�������\Q3_rawdata.txt" FIRSTOBS=5 OBS=8 EXPANDTABS;
INPUT lastname $1-4 firstname $ 5-12 gender $ 13-18 score 6.1 ;

fullname = compress(lastname || "," ) ||" " || firstname;


*�� �۾� (1)���� ������ SAS �����ͼ� <one>�� ���� score �� ����, ������������
���Ľ�Ų��. ;
PROC SORT;
BY DESCENDING score;

* �� �۾�(2)���� ������ SAS �����ͼ��� �̿��Ͽ� �ӽö��̺귯�� work �ؿ� ����
gender ���� ��Male���� ����ġ�鸸 ���Ե� SAS �����ͼ� <two>�� ����/�����ϵ� 3��
������(gender, score, fullname)�� ���Խ�Ű���� �Ѵ�. ���� ���â�� �Ʒ��� ����
������ PUT�ǵ��� �Ѵ�. ;

DATA two(keep=gender score fullname);
set one;
if gender="Male" then output two;

data _NULL_;
set two;
file print;
if _N_=1 then put
@21 30*"*" 
/@29 "Male�� ����ġ��"
/@21 30*"*"
/@21 "<Fullname>    <Score>   <����>";
PUT @21 fullname @36 score 6.2 @46 _N_"��";
run;
