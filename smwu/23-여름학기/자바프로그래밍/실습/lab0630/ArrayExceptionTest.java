//2023-07-02
//Lab0630-5: 예외처리: 문자 빈도수 체크

import java.util.Scanner;

public class ArrayExceptionTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("문장 입력: ");
		String s = scan.nextLine();

		int[] count = new int[26]; // 빈도수를 담을 26크기의 배열
		for (int i = 0; i < count.length; i++) // 0으로 초기화
			count[i] = 0;
		s = s.toUpperCase(); // 대문자 변환

		for (int i = 0; i < s.length(); i++) {
			try {
				count[s.charAt(i) - 'A']++; // 정수로 변환해 인덱스로 만들고 개수 증가
			} catch (ArrayIndexOutOfBoundsException e) { //예외처리
				System.out.println("ArrayIndexOutOfBoundsException 발생!!");
			}
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) //다시 문자로 변환 후 출력
				System.out.println("문자 " + (char) (i + 'A') + ": " + count[i] + "번");
		}
		scan.close();
	}

}