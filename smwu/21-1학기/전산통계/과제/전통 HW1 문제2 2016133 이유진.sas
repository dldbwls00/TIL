*��� <C:��Class���������> �ؿ� ����Ǿ� �ִ� ��(��)�ڷ� <HW1_Q2_rawdata.txt>
�� �ҷ��ٰ� �Ʒ��� ���� ������ SAS �����ͼ� <three>�� �ӽö��̺귯�� work ��
�� ����/�����Ѵ�. ��, �� �����ͼ¿� �������� status, id, major, class, course ��
����� �����ǵ��� �۾��Ѵ�. ���� class ��� �������� ��02���̸鼭 major ��� ����
���� ��Stat���� ����ġ�鿡 ���� ��� ���������� ���â�� PUT�ǵ��� �Ѵ�.;
LIBNAME mydata "C:\Class\�������";
DATA work.three;
INFILE "C:\Class\�������\HW1_Q2_rawdata.txt" FIRSTOBS=13 OBS=30;
INPUT #1 status $ 1;
IF status='S' THEN INPUT #1 @3 id #2 @12 major $ @10 class $ @1 course $  #3;
ELSE IF status='P' THEN INPUT #2 course $ #3;

FILE PRINT;
IF class="02" AND major="Stat" THEN PUT status $ id major $ class $ course $;
RUN;
* �� �۾� (1)���� ������ SAS �����ͼ� <three>�� ��� <C:��Class���������> �ؿ� <finaldata.txt>��� �ؽ�Ʈ ���Ϸ� ���������� �Ѵ�.
�� �۾� �κп� ���� ���� SAS ���α׷� ���뵵 �����ϴ� ���α׷�����, �ʿ��� ��ġ�� ���Խ��Ѽ� �����ϵ��� �Ѵ�. ;
PROC EXPORT DATA= WORK.THREE 
            OUTFILE= "C:\Class\�������\finaldata.txt" 
            DBMS=TAB REPLACE;
     PUTNAMES=YES;
RUN;
