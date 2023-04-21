// 이유진 (2016133)
// 2021-10-08
// Lab05 - 실습 4. 갬블링 게임
import java.util.Scanner;

public class GamblingGame{
	private Player [] p = new Player[2];
	private Scanner scanner = new Scanner(System.in);
	public GamblingGame() {
		for (int i=0; i<p.length; i++) {
			System.out.print((i+1)+"번째 선수 이름>>");
			String name = scanner.nextLine(); //사용자로부터 이름을 입력받아서 Player 객체 생성
			p[i] = new Player(name);
		}
	}
	public void run() {
		for (int i=0; ; i++) {//반복문을 돌면서
			if(p[i%2].turn()) {//각 선수의 세 수가 모두 같은 경우(즉, 각 선수의 turn()을 호출해서 true인 경우)
				System.out.println(p[i%2].getName()+"님이 이겼습니다!");//적절한 메세지 출력 후 종료
				break;
			}
			else {//각 선수의 세 수가 모두 같지 않은 경우
				System.out.println("아쉽군요!");//적절한 메세지 출력 후 반복문 계속 반복
			}
		}
	}
	public static void main(String[] args) {
		GamblingGame game = new GamblingGame();
		game.run();
		
	}
}
