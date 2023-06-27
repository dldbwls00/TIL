//이유진 (2016133)
//2023-06-27
//Lab0627-2: Car 클래스를 이용해 static변수와 메소드 실습

class Car {
	private String model;
	private String make;
	private static int numberOfCars = 0; //생산된 차의 개수를 저장하는 정적 변수

	// 생성자
	public Car(String model, String make) {
		super();
		this.model = model;
		this.make = make;
		numberOfCars++; //생산된 차의 수 증가
	}

	// 설정자, 접근자
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	// 접근자 getNumberOfCars() 대신 정적 변수를 외부로 반환해주는 정적 메소드 사용
	public static int getNumberOfCars() {
		return numberOfCars;
	}
	
	// 설정자 setNumberOfCars()는 생성자에서 numberOfCars를 올리므로 사용하지 않음
	// 별도의 toString() 메소드 필요하지 않음

}

public class CarTest {

	public static void main(String[] args) {

		new Car("3SERIES", "BENZ");
		new Car("3SERIES", "BENZ");
		new Car("3SERIES", "BENZ");
		System.out.println("총 " + Car.getNumberOfCars() + "대의 자동차가 생산되었습니다.");
	}

}
