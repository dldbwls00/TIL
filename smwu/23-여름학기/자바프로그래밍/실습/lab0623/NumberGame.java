//이유진 (2016133)
//2023-06-23
//Lab0623-2: 컴퓨터가 생성한 난수(1~100)를 맞추기

import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {

		int computer = (int) ((Math.random() * 100) + 1); // 1~100 정수 랜덤값 생성
		int cnt = 0; // 시도 횟수
//		System.out.println(computer); // 랜덤값 확인

		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("정답을 추측하여 보시오: ");
			int num = scanner.nextInt(); // 정수 입력받기

			if (num < 1 || num > 100) { // 입력 유효값 체크
				System.out.println("유효하지 않은 값! 1~100 사이의 정수를 입력하시오.");
				continue;
			}

			if (num < computer) // 난수가 입력 받은 정수보다 큰 경우
				System.out.println("더 높아요.");
			else if (num > computer) // 난수가 입력 받은 정수보다 작은 경우
				System.out.println("더 낮아요.");
			else {
				System.out.print("축하합니다. 시도횟수=" + ++cnt); // ++cnt: 마지막 시도 횟수를 포함하기 위함
				scanner.close();
				break;
			}
			cnt++;
		}

	}

}
