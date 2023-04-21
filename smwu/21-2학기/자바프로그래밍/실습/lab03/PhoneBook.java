// 이유진 (2016133)
// 2021-09-24
// Lab03 - 실습 4. 전화번호부
import java.util.Scanner;

class Phone{
	private String name, tel;
	
	public Phone(String name, String tel) { //생성자 -> 초기화 
		this.name = name;
		this.tel = tel;
	}
	public String getName() { //private변수에 접근하기 위한 get
		return name;
	}
	public void printTel(String s) { //출력메서드
		System.out.println(s+"의 번호는 "+tel+" 입니다.");
	}
}
public class PhoneBook {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //스캐너 객체 
		System.out.print("인원수>>"); //저장할 사람의 수 입력받기
		int n = scanner.nextInt();
		
		Phone [] p = new Phone[n]; //Phone 객체 배열 생성
		
		for (int i=0; i<p.length; i++) {//한 사람의 정보는 하나의 Phone 객체에 저장
			System.out.print("이름과 전화번호(이름과 번호는 빈칸없이 입력)>>");
			String name = scanner.next();
			String tel = scanner.next();
			p[i] = new Phone(name, tel);
		}
		System.out.println("저장되었습니다...");
		
		while(true) {
			System.out.print("검색할 이름>>");
			String s = scanner.next();
			if (s.equals("그만"))	break; //문자열 a와 b가 같은지 비교할 때 a.equals(b)가 참인지로 판단
			
			for (int i=0; i<p.length; i++) { //번호 출력문
				if (s.equals(p[i].getName()))	p[i].printTel(s);
			}
		}
		scanner.close();
	}

}
