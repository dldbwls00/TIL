//이유진 (2016133)
//2023-07-02
//Lab0630-3: String 클래스 활용: 문자열 split

import java.util.Scanner;

public class StringSplitTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("문자열 입력: ");
		String s = scan.nextLine();

		String sSplit[] = s.split(" "); // split 메서드: 공백을 기준으로 문자열 분리
		for (int i = 0; i < sSplit.length; i++)
			System.out.print(sSplit[i] + " / ");
		System.out.println();
		System.out.println("단어 개수: " + sSplit.length);

		scan.close();
	}

}
