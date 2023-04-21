// 이유진 (2016133)
// 2021-10-08
// Lab05 - 실습 4. 갬블링 게임
import java.util.Scanner;

public class Player {
	private String name;
	private Scanner scanner = new Scanner(System.in);
	
	public Player(String name) { //생성자 초기화
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public boolean turn() {
		System.out.print("["+name+"]:<Enter>");
		String input = scanner.nextLine();//참가자가 <Enter>키 입력할 때까지 기다림
		
		int n1 = (int)(Math.random()*3+1); //3개의 난수 생성: 1~3 사이의 랜덤 정수
		int n2 = (int)(Math.random()*3+1);
		int n3 = (int)(Math.random()*3+1);
		
		System.out.print("\t\t"+ n1 + "\t" + n2 + "\t" + n3 + "\t"); //3개의 난수 출력
		
		if (n1==n2 && n2==n3)//3개의 난수가 같은지 비교
			return true; //3개의 난수가 같으면 true 반환
		else return false; //그렇지 않으면 false 반환
	}
}
