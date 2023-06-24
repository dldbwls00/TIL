//이유진 (2016133)
//2023-06-23
//Lab0623-1: 입력받은 두 자리 정수의 십의 자리와 일의 자리가 같은지 판별

import java.util.Scanner;

public class NumberTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) { // 유효값 확인
			System.out.print("2자리수 정수 입력(10~99)>> ");
			int num = scanner.nextInt(); // 정수 입력받기

			if (num < 10 || num > 99) { //값이 유효하지 않은 경우
				System.out.println("유효하지 않은 값!");
				continue;
			} else { //값이 유효한 경우
				int ten = num / 10; // 십의 자리 수
				int one = num % 10; // 일의 자리 수

				if (ten == one)// 십의 자리와 일의 자리가 같은 경우
					System.out.println("Yes! 10의 자리와 1의 자리가 같습니다");
				else // 십의 자리와 일의 자리가 다른 경우
					System.out.println("No! 10의 자리와 1의 자리가 다릅니다");

				break;
			}
		}

		scanner.close();
	}
}
