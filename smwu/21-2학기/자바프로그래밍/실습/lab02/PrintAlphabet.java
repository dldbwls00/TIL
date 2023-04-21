// 이유진 (2016133)
// 2021-09-17
// Lab02 - 실습 2. 알파벳 입력받고 문자열 출력하기
import java.util.Scanner;

public class PrintAlphabet {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("소문자 알파벳 하나를 입력하시오>> ");
		String alphabet = scanner.next(); //Scanner는 문자를 입력받는 기능이 없으므로 문자열을 입력받음
		char c = alphabet.charAt(0); //문자열의 첫 번째 문자
		
		for(; c>='a'; c--) { //a부터 입력받은 문자 c까지를 출력하며 끝글자부터 하나씩 줄여가므로, c를 1씩 감소시킨다.
			for(char s = 'a'; s<=c; s++) //a부터 입력받은 문자 c까지 출력한다.
				System.out.print(s);
			System.out.println(); //줄바꿈
		}
		scanner.close();
	}

}
