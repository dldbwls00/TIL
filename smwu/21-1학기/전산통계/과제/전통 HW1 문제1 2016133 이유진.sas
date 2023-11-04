**��� <C:��Class���������> �ؿ� ����Ǿ� �ִ� ��(��)�ڷ� <HW1_Q1_rawdata.txt>
�� �ҷ��ٰ� �Ʒ��� ���� ������ SAS �����ͼ� <one>�� ��� <C:��Class��������
��> �ؿ� ����/�����Ѵ�. ;
LIBNAME mydata "C:\Class\�������";
DATA mydata.one;
INFILE "C:\Class\�������\HW1_Q1_rawdata.txt" FIRSTOBS=11 OBS=14;
INPUT fullname $ 1-10 gender $ 11-17 exam1 18-20 exam2 21-23  exam3 24-26 exam4 27-29;
RUN;
*�� �۾� (1)���� ������ SAS �����ͼ� <one>�� �̿��Ͽ� ������ ���� 3�� ������
(total, ave, grade)�� �߰��� ���ο� SAS �����ͼ� <two>�� �ӽö��̺귯���� work
�ؿ� ����/�����Ѵ�. ��, �� SAS �����ͼ� <two>���� 5�� ������(fullname, gender,
total, ave, grade)�� ���Եǵ��� �Ѵ�. ;
DATA work.two(DROP=exam1 exam2 exam3 exam4);
SET mydata.one;
* ������ ���������� 0������ �����Ͽ� ���;
if exam3=. then exam3=0;
if exam4=. then exam4=0;
total=exam1+exam2+exam3+exam4;
ave=MEAN(exam1, exam2, exam3, exam4);
IF ave < 70 THEN grade="���հ�";
		ELSE grade="�հ�";
RUN;
