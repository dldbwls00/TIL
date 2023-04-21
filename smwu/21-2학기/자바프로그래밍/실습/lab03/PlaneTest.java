// 이유진 (2016133)
// 2021-09-24
// Lab03 - 실습 6. 비행기
class Plane{
	private String model;//필요한 멤버 변수(필드) 선언
	private int seats;
	static int planes; //정적 변수
	
	public Plane() {//생성자 작성: 여러 개 중복 정의
		planes++;
	}
	public Plane(String model) {
		this.model = model;
		planes++;
	}
	public Plane(String model, int seats) {
		this.model = model;
		this.seats = seats;
		planes++;
	}
	public Plane(int seats) {
		this.seats = seats;
		planes++;
	}
	
	//멤버 변수를 접근할 수 있는 접근자(getXXX)와 설정자 메소드(setXXX) 작성
	public String getModel() { //접근자
		return model;
	}
	public int getSeats() { //접근자
		return seats;
	}
	public void setModel(String model) { //설정자
		this.model = model;
	}
	public void setSeats(int seats) { //설정자
		this.seats = seats;
	}

	public int getPlanes() {//정적 변수 접근할 수 있는 접근자 메소드 getPlanes() 작성
		return planes;
	}
	
	public String toString(){ //객체의 정보를 문자열로 반환하는 toString 메소드 작성
		return "Plane [model = "+model+", seats = "+seats+"]";//오버라이딩해야됨
	}
}
public class PlaneTest {

	public static void main(String[] args) {
		Plane p1, p2, p3, p4; //Plane 객체 여러 개 생성
		p1 = new Plane();
		p1.setModel("보잉 777");
		p1.setSeats(200);
		p2 = new Plane("보잉 747");
		p2.setSeats(400);
		p3 = new Plane("에어버스 A380", 500);
		p4 = new Plane(120);
		p4.setModel("보잉 737");
		
		System.out.println("전체 보유 비행기 수: "+p1.getPlanes());//전체 보유 비행기 수 출력
		
		//비행기 정보 출력
		System.out.println("==============전체 비행기 출력==============");
		System.out.println(p1); //내부적으로 toString 메소드가 호출됨
		System.out.println(p2);
		System.out.println("Plane [model = " + p3.getModel() + ", seats = " + p3.getSeats() + "]");
		System.out.println(p4);
	}

}
