*2�ܺ��� 19�ܱ����� �������� �����ϴ� �۾�����, ¦������ <even>�̶�� SAS �����ͼ�
����, Ȧ������ <odd>��� SAS �����ͼ����� ����/�����Ѵ�. ��, �� ���� DATA �ܰ迡
�� �۾��� �Ͽ��� �Ѵ�. ;
data even odd;
do dan=2 to 19 by 1;
	do k=1 to 9 by 1;
		result = dan * k;
		if mod(dan,2)=0 then output even;
		else output odd;
	end;
end;
run;
