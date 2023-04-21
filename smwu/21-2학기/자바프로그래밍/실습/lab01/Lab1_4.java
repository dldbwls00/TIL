// 이유진 (2016133)
// 2021-09-10
// Lab01 - 실습 3. 정수 3개 입력받고 중간 크기 수 출력하기
import java.util.Scanner;

public class Lab1_4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수 3개 입력>>");
		
		//세 개의 정수 입력받기
		int n1 = scanner.nextInt();
		int n2 = scanner.nextInt();
		int n3 = scanner.nextInt();
		
		int mid;
		
		//중첩 if-else문으로 중간값을 찾아 변수 mid에 담는다
		if (n1 > n2) {
			if (n2 > n3)	mid = n2; //n1 > n2 > n3인 경우
			else {
				if (n1 > n3)	mid = n3; //n1 > n3 > n2인 경우
				else	mid = n1; //n3 > n1 > n2인 경우
			}
		}
		else {
			if (n1 > n3)	mid = n1; //n2 > n1 > n3인 경우
			else {
				if (n2 > n3)	mid = n3; //n2 > n3 > n1인 경우
				else	mid = n2; //n3 > n2 > n1인 경우
			}
		}

		System.out.println("중간 값은 " + mid); //결과 출력
	}
}
