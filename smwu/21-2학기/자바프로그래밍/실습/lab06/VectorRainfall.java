// 이유진 (2016133)
// 2021-10-08
// Lab06 - 실습 2. 강수량 관리 프로그램

import java.util.Scanner;
import java.util.Vector;

public class VectorRainfall {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //scanner 객체
		Vector<Integer> v = new Vector<Integer>(); //vector 객체
		int sum = 0, cnt = 0, ave = 0;
		
		while (true) {
			System.out.print("강수량 입력(0 입력시 종료)>> ");
			int n = scanner.nextInt();
			if (n == 0) break;
			
			cnt++;
			sum += n; //합 갱신
			ave = sum/cnt; //평균 계산
			v.add(n); //벡터에 추가
			
			for (int i=0; i<v.size(); i++)	System.out.print(v.get(i)+" "); //출력문
			System.out.println();
			System.out.println("현재 평균 " + ave);
		}
		scanner.close();
	}

}
