// 이유진 (2016133)
// 2021-09-10
// Lab01 - 실습 2. 두 자리 정수 입력받고, 십의 자리와 일의 자리가 같은지 판별하기
import java.util.Scanner;

public class Lab1_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("2자리수 정수 입력(10~99)>>");
		
		int num = scanner.nextInt(); //정수 입력받기
		
		int ten = num / 10; //십의 자리 따로 저장
		int one = num % 10; //일의 자리 따로 저장
		
		// 십의 자리와 일의 자리가 같은지 다른지 판별하는 if-else문
		if (ten == one)	System.out.println("Yes! 10의 자리와 1의 자리가 같습니다");  //같은 경우
		else System.out.println("No! 10의 자리와 1의 자리가 다릅니다"); //다른 경우
	}

}
