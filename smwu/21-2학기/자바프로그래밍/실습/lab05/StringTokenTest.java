// 이유진 (2016133)
// 2021-10-08
// Lab05 - 실습 6. 문자열 분리: token
import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenTest {

	public static void main(String[] args) {
		System.out.print("문자열 입력 : ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		
		StringTokenizer st = new StringTokenizer(s, " "); //문자열 분리
		int cnt = st.countTokens(); //토큰의 개수를 담아두는 변수
		
		while (st.hasMoreTokens()) //출력
			System.out.print(st.nextToken()+" / ");
		System.out.println();
		System.out.println("단어 개수: "+cnt);
		
		scanner.close();
	}

}
