//이유진 (2016133)
//2023-07-02
//Lab0630-2: String 클래스 활용: 문자열 회전

import java.util.Scanner;

public class StringRotate {

	public static void main(String[] args) {

		System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다.");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		for (int i = 1; i <= s.length(); i++) { // substring 메서드 사용
			System.out.print(s.substring(i)); // [i, 끝)범위 자르기
			System.out.print(s.substring(0, i)); // [0, i)범위 자르기
			System.out.println();
		}
		scan.close();
	}

}
