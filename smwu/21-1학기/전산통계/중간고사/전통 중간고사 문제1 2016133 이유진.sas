* ��� <C:��Class���������> �ؿ� ����Ǿ� �ִ� <�������.txt> ������ �ҷ��ٰ� ��
���� ���� ������ SAS �����ͼ� <comput>�� �ӽö��̺귯�� work �ؿ� ����/����
�Ѵ�. ��, ������ major, id, ave_comput, axam1, exam2, exam3 ������� �Է���
�� ave_comput �������� (�Ҽ��� 3�� ° �ڸ����� �ݿø��Ͽ�) �Ҽ��� 2�� ° �ڸ�
������ ���ǵ��� �Ѵ�. ���� ������ ���� ���ο� ���� 2��(course, grade)�� �߰�
�����ǵ��� �Ѵ�. ;
DATA comput;
INFILE "C:\Class\�������\�������.txt" FIRSTOBS=13 OBS=44 EXPANDTABS;
INPUT #2 major $ 1-14 #1 id $  #3 ave_comput 1-10 exam1 exam2 exam3 #4 ;

ave_comput = round(ave_comput, 0.01);
course = "�������";
IF substr(id, 1, 2)="20" then grade="2�г�";
else if substr(id, 1, 2)="19" then grade="3�г�";

*<ȸ�ͺм�_����.txt>�� <ȸ�ͺм�_����.txt>�� �� ���� ���Ͽ� �ӽö��̺귯�� work
�ؿ� �Ʒ��� ���� SAS �����ͼ� <reg>�� ����/�����Ѵ�.;

DATA a1;
INFILE  "C:\Class\�������\ȸ�ͺм�_����.txt"  FIRSTOBS=8 OBS=25 EXPANDTABS;
INPUT id $ #2 ave_reg;
PROC SORT;
BY id;
DATA a2;
INFILE "C:\Class\�������\ȸ�ͺм�_����.txt" FIRSTOBS=9 OBS=26 EXPANDTABS;
INPUT id $ #2 major $ 1-14;
PROC SORT;
BY id;
DATA reg;
MERGE a2 a1;

*) �� �۾� (1)�� (2)���� ���� ������ SAS �����ͼ� <comput>�� <reg>�� ���Ͽ� �ӽ�
���̺귯�� work �ؿ� SAS �����ͼ� <all>�� ����/�����ϵ� ������ major, id,
ave_comput, grade, ave_reg �� ����ǵ��� �Ѵ�. �����, ������� ���� ������
�鼭 ȸ�ͺм� ���� �����ϴ� �л�(��)�� �����Ѵ�. ;
proc sort data=comput;
by id;
DATA all (keep= major id ave_comput grade ave_reg);
merge reg comput;
by id;
run;

*�� �۾� (3)���� ������ SAS �����ͼ� <all>�� �̿��Ͽ� ��� <C:\calss\�������>
�ؿ� ������ ���� �� ���� SAS �����ͼ� <one>�� <two>�� ����/�����Ѵ�. SAS �����ͼ� <one>���� ������� ����� ȸ�ͺм� ���� �� �� ���� �����ϴ� ��
��(��)�� ���Խ�Ű�� 5�� ������(id, major, grade, ave_comput, ave_reg)�� �����
���� �Ѵ�. SAS �����ͼ� <two>���� ������� ����� ȸ�ͺм� ���� �Ѵ� �����ϴ�
�л�(��)�� ���Խ�Ű�� 4�� ������(id, major, grade, ave)�� ����ǵ��� �Ѵ�. ��, ��
�۾��� �� ���� DATA �ܰ迡�� �۾��� �Ͽ��� �Ѵ�. ;

LIBNAME mydata "C:\Class\�������";
DATA mydata.one(keep=id major grade ave_comput ave_reg) mydata.two (keep=id major grade ave);
set all;

ave = MEAN(ave_comput, ave_reg);
IF (ave_reg = .) or (ave_comput = .) then output mydata.one;
else if  (ave_reg ~= .) or (ave_comput ~= .) then output mydata.two;
RUN;
