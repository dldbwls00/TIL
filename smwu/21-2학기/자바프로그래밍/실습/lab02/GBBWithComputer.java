// 이유진 (2016133)
// 2021-09-17
// Lab02 - 실습 7. 컴퓨터와 가위바위보
import java.util.Scanner;

public class GBBWithComputer {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str[] = {"가위", "바위", "보"};
		
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		while(true) {
			System.out.print("가위 바위 보!>>");
			String input = scanner.next(); //사용자의 선택 입력받기
			
			if (input.equals("그만")) { //"그만"을 입력할 경우 게임 종료
				System.out.println("게임을 종료합니다...");
				break;
			}
			
			int n = (int)(Math.random()*3); //0, 1, 2중에 랜덤하게 결정
			System.out.print("사용자 = "+input+" , 컴퓨터 = "+str[n]+", ");
			
			if (str[n].equals("가위")) {
				if (input.equals("가위"))			System.out.println("비겼습니다.");
				else if (input.equals("바위"))	System.out.println("사용자가 이겼습니다.");
				else							System.out.println("컴퓨터가 이겼습니다.");
			}
			else if (str[n].equals("바위")) {
				if (input.equals("가위"))			System.out.println("컴퓨터가 이겼습니다.");
				else if (input.equals("바위"))	System.out.println("비겼습니다.");
				else							System.out.println("사용자가 이겼습니다.");
			}
			else {
				if (input.equals("가위"))			System.out.println("사용자가 이겼습니다.");
				else if (input.equals("바위"))	System.out.println("컴퓨터가 이겼습니다.");
				else							System.out.println("비겼습니다.");
			}
			
		}
		scanner.close();
	}

}
