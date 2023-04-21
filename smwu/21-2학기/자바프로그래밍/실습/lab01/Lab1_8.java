// 이유진 (2016133)
// 2021-09-10
// Lab01 - 실습 5. 직사각형 충돌 판별 프로그램
import java.util.Scanner;

public class Lab1_8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//왼쪽 상단 점이 (x1, y1), 오른쪽 하단 점이 (x2, y2)이도록 입력받음
		System.out.print("x1, y1 입력>>");
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		System.out.print("x2, y2 입력>>");
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		
		//겹치는지 여부를 판별하는 if-else문
		if (x1>200 || y1>200 || x2<100 || y2<100)	System.out.println("충돌 없음"); //겹치지 않는 경우
		else	System.out.println("충돌 발생"); //겹치는 경우 
		
	}
}
