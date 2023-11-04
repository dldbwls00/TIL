*2단부터 19단까지의 구구단을 생성하는 작업으로, 짝수단은 <even>이라는 SAS 데이터셋
으로, 홀수단은 <odd>라는 SAS 데이터셋으로 생성/저장한다. 단, 한 개의 DATA 단계에
서 작업을 하여야 한다. ;
data even odd;
do dan=2 to 19 by 1;
	do k=1 to 9 by 1;
		result = dan * k;
		if mod(dan,2)=0 then output even;
		else output odd;
	end;
end;
run;
