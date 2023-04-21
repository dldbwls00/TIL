// 이유진 (2016133)
// 2021-09-10
// Lab01 - 실습 6. 두 원이 서로 겹치는지 판단
import java.util.Scanner;

public class Lab1_10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//왼쪽 상단 점이 (x1, y1), 오른쪽 하단 점이 (x2, y2)이도록 입력받음
		System.out.print("원의 중심 x1, y1, 반지름 radius1 >> ");
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int radius1 = scanner.nextInt();
		System.out.print("원의 중심 x2, y2, 반지름 radius2 >> ");
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		int radius2 = scanner.nextInt();
		
		//좌표평면 위의 두 점 사이 거리 구하는 공식
		double distance = Math.sqrt(Math.pow((x2-x1),  2)+Math.pow(y2-y1, 2));
		
		// 두 원이 겹치는지 판단하는 if-else문 (접하는 경우도 겹치는 경우에 포함)
		// 두 반지름의 합이 두 원의 중심 사이 거리보다 클 때 겹치지 않는다
		if (distance > radius1+radius2)	System.out.println("두 원은 서로 겹치지 않는다."); //겹치지 않는 경우
		else	System.out.println("두 원은 서로 겹친다."); //겹치는 경우
	}

}
