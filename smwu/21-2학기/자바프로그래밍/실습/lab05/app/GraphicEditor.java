// 이유진 (2016133)
// 2021-10-08
// Lab05 - 실습 2. 패키지 작성 연습
package app;

import base.Shape;
import derived.Circle2;

public class GraphicEditor {

	public static void main(String[] args) {
		Shape shape = new Circle2();
		shape.draw();
	}

}
