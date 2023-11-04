	*��� <C:��Class���������> �ؿ� ����Ǿ� �ִ� 9���� SAS �����ͼ� ���ϵ��� ��
���Ͽ� �ӽö��̺귯�� work �ؿ� 3���� SAS �����ͼ� <eng>, <math>, <sci>�� ��
��/�����Ѵ�. ;
DATA eng;
SET "C:\Class\�������\eng_01" "C:\Class\�������\eng_02" "C:\Class\�������\eng_03";
DATA math;
SET "C:\Class\�������\math_01" "C:\Class\�������\math_02" "C:\Class\�������\math_03";
DATA sci;
SET "C:\Class\�������\sci_01" "C:\Class\�������\sci_02" "C:\Class\�������\sci_03";

*�� �۾�(1)���� ������ 3���� SAS �����ͼµ�(<eng>, <math>, <sci>)�� �̿��Ͽ�
��� ��(1, 2, 3��) �л����� ��� ����(����, ����, ����) ������ ���Ե� SAS ������
�� <all>�� �ӽö��̺귯�� work �ؿ� ����/�����Ѵ�. ���� �� SAS �����ͼ� <all>��
�� ���ο� ���� total�� �߰��� �����ϰ� �� ���� total �� ��������, ������������ ��
���Ѵ�. ;
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
