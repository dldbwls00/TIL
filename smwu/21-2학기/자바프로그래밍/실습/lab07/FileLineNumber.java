// 이유진 (2016133)
// 2021-10-22
// Lab07 - 실습 2. 파일에 라인번호 붙이기
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileLineNumber {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new FileReader("c:\\windows\\system.ini"));
		//스캐너 객체 -> 파일 읽어오기
		
		System.out.println("c:\\windows\\system.ini 파일을 읽어 출력합니다.");
		int cnt = 1; //인덱스 
		while(scanner.hasNext()) { //다음이 있는 경우 계속 반복
			System.out.printf("%4d: ", cnt); //형식지정자
			System.out.println(scanner.nextLine()); //한 줄씩
			cnt++;
		}
		scanner.close();
	}

}
