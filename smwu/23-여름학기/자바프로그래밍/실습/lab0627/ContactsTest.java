//이유진 (2016133)
//2023-06-27
//Lab0627-4: Contacts 클래스와 ArrayList를 활용한 연락처 저장 프로그램

import java.util.ArrayList;
import java.util.Scanner;

class Contacts {
	private String name;
	private String tel;
	private String email;
	private static int count = 0; // 지인들의 수를 저장하는 정적 변수

	// 생성자
	public Contacts(String name, String tel, String email) {
		super();
		this.name = name;
		this.tel = tel;
		this.email = email;
		count++; // 연락처 수 증가
	}

	// 설정자, 접근자
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static int getCount() {
		return count;
	}

	// setCount 설정자는 생성자에서 count를 올리므로 사용하지 않음

	@Override
	public String toString() {
		return name + "의 전화번호:" + tel + " 이메일: " + email;
	}

}

public class ContactsTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<Contacts> cArr = new ArrayList<>(); // 동적으로 추가하기 위해 ArrayList 사용

		System.out.println("연락처를 입력하시오(종료 -1)");
		while (true) {

			// 사용자로부터 정보를 입력받음
			System.out.print("이름과 전화번호, 이메일을 입력하시오: ");
			String name = scan.next();
			if (name.equals("-1")) { // 종료 조건
				System.out.println("지인들의 수는 " + Contacts.getCount() + "입니다");
				break;
			}
			String tel = scan.next();
			String email = scan.next();

			Contacts c = new Contacts(name, tel, email);
			if (Contacts.getCount() > 100) { // 종료 조건: 최대 100개 저장
				System.out.println("저장 개수 초과!");
				break;
			}
			cArr.add(c); // ArrayList에 추가
		}

		System.out.print("검색할 이름을 입력하시오: ");
		String key = scan.next();
		for (int i = 0; i < cArr.size(); i++) {
			if (key.equals(cArr.get(i).getName())) { // ArrayList에 key를 이름으로 갖는 연락처가 있는 경우
				System.out.println(cArr.get(i));
			}
		}
		scan.close();
	}

}
