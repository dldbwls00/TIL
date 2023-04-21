// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 5. 추상 클래스 실습 - 도형의 면적
package prob5;

interface Shape2 {
	final double PI = 3.14;
	void draw(); //도형을 그리는 추상메서드
	double getArea(); //도형의 면적을 리턴하는 추상메서드
	default public void redraw() { //디폴트 메서드
		System.out.print("--- 다시 그립니다. ");
		draw();
	}
}
