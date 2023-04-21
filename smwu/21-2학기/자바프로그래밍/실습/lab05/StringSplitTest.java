// 이유진 (2016133)
// 2021-10-08
// Lab05 - 실습 6. 문자열 분리: split
import java.util.Scanner;

public class StringSplitTest {

	public static void main(String[] args) {
		System.out.print("문자열 입력 : ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		
		String ssplit [] = s.split(" "); //문자열 분리
		
		for (int i=0; i<ssplit.length; i++) //출력
			System.out.print(ssplit[i]+" / ");
		System.out.println();
		System.out.println("단어 개수: "+ssplit.length);
		
		scanner.close();
	}

}
