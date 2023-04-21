// 이유진 (2016133)
// 2021-09-24
// Lab03 - 실습 2. 직사각형 표현
public class Rectangle {
	int x, y,  width, height; //int 타입의 x, y, width, height 필드: 사각형을 구성하는 점과 크기 정보
	
	public Rectangle(int x, int y, int width, int height) {// x, y, width, height 값을 매개 변수로 받아 필드를 초기화하는 생성자
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int square() {//사각형 넓이 리턴
		return width * height;
	}
	
	public void show() {//사각형의 좌표와 넓이를 화면에 출력
		System.out.println("(" + x + "," + y + ")에서 크기가 " + width + "x" + height + "인 사각형");
	}
	
	public boolean contains(Rectangle r) {//매개변수로 받은 r이 현 사각형 안에 있으면 true 리턴
		if (this.x < r.x && r.x < this.x+this.width //조건: r의 좌측상단점과 우측하단점이 모두 현 사각형 안에 있어야함
				&& this.y < r.y && r.y < this.y+this.height
				&& r.x+r.width < this.x+this.width
				&& r.y+r.height< this.y+this.height)	return true;
		return false;
	}
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(2, 2, 8, 7); //객체 생성
		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10);
		
		r.show(); //메서드 호출
		System.out.println("s의 면적은 " + s.square());
		if (t.contains(r))	System.out.println("t는 r을 포함합니다.");
		if (t.contains(s))	System.out.println("t는 s를 포함합니다.");
	}

}
