//이유진 (2016133)
//2023-06-26
//Lab0626-1: Person 클래스를 이용해 사람의 정보를 출력함

class Person {
	// 필드 작성
	private String name;
	private String mobile;
	private String office;
	private String email;

	// 생성자
	public Person(String name, String mobile, String office, String email) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.office = office;
		this.email = email;
	}

	// 접근자, 설정자
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString 메소드
	@Override
	public String toString() {
		return "Person [name=" + name + ", mobile=" + mobile + ", office=" + office + ", email=" + email + "]";
	}
}

public class PersonTest {

	public static void main(String[] args) {

		Person obj = new Person("Kim", "01012345678", "027104567", "a@b.c"); //Person 객체 선언 후 생성
		System.out.println(obj);
	}

}
