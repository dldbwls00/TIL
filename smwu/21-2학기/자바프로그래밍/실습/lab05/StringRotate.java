// 이유진 (2016133)
// 2021-10-08
// Lab05 - 실습 3. 문자열 회전
import java.util.Scanner;

public class StringRotate {

	public static void main(String[] args) {
		System.out.println("문자열을 입력하세요. 빈칸이 있어도 되고 영어 한글 모두 됩니다.");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine(); // 문자열 한 줄 입력
		for (int i=1; i<=s.length(); i++) {
			System.out.print(s.substring(i)); //substring 메서드 사용
 			System.out.println(s.substring(0,i)); //0포함 i포함x
		}
		scanner.close();
	}

}
