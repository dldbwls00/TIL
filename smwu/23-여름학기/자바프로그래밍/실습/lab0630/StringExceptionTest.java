//이유진 (2016133)
//2023-07-02
//Lab0630-4: 예외처리: 정수 입력받아 합 구하기

import java.util.Scanner;

public class StringExceptionTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("여러 개의 정수 입력: ");
		String s = scan.nextLine();

		String sSplit[] = s.split(" "); // split 메서드: 공백을 기준으로 문자열 분리
		int sum = 0;
		for (int i = 0; i < sSplit.length; i++) {
			try {
				sum += Integer.parseInt(sSplit[i]); // 정수형으로 변환 후 sum
			} catch (NumberFormatException e) { // 예외처리
				System.out.println("NumberFormatException 발생!!");
			}
		}
		System.out.println("정수들의 합은 " + sum);
		scan.close();
	}

}
