// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 4. 추상 클래스 실습 : 그래픽 편집기
package prob4;

import java.util.Scanner;

public class GraphicEditor {
	private String name;
	public GraphicEditor(String name) {
		this.name = name;
	}
	private Scanner scanner = new Scanner(System.in);
	private Shape start = null, end = null;
	private int cnt=0;
	
	
	public void run() {
		System.out.println("그래픽 에디터 beauty를 실행합니다.");
		int choice = 0;
		
		while(true) { //반복문을 돌면서 메뉴 출력 및 메뉴 기능 실행
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
			choice = scanner.nextInt();
			
			if (choice == 1 ) { //삽입의 경우 insert 메소드 호출
				System.out.print("Line(1), Rect(2), Circle(3)>>");
				insert(scanner.nextInt());
			}
			else if (choice == 2) { //삭제의 경우 delete 메소드 호출
				System.out.print("삭제할 도형의 위치>>");
				delete(scanner.nextInt());
			}
			else if (choice == 3) {//모두 보기의 경우 연결 리스트 이동하면서 해당 값 출력
				Shape p = start;
				while(p != null) {
					p.draw(); //객체에 따라 다른 draw 호출됨
					p = p.getNext();
				}
			}
			else if (choice == 4)	break;//종료의 경우 반복문 빠져나가기
		}
		System.out.println("beauty를 종료합니다.");
	}
	
	private boolean delete(int index) {
		int temp = cnt; //임시 보관
		if (start == null || index > cnt) {//리스트가 빈 경우 또는 해당 위치에 원소가 없을 경우
			return false;
		}
		//연결 리스트에서 해당 위치로 이동 후 해당 원소 삭제
		if (cnt == 0) {//리스트에 원소가 한 개밖에 없는 경우
			start = null;
			end = null;
		}
		else if (index == 0) {//첫 번째 원소를 삭제하는 경우
			start = start.getNext(); //시작점 이동
		}
		else if (index == cnt) {//마지막 원소를 삭제하는 경우
			Shape  a = start, p = start;
			while(temp == cnt-index-1) {
				a = p;
				p = p.getNext();
				temp--;
			}
			a.setNext(p.getNext());
		}
		else {//중간 원소를 삭제하는 경우
			Shape  a = start, p = start;
			while(temp == cnt-index-1) {
				a = p;
				p = p.getNext();
				temp--;
			}
			a.setNext(p.getNext());
		}
		cnt--; //전체 개수 감소
		return true; //성공적으로 삭제했을 경우 true 반환
	}
	
	private void insert(int choice) {
		if (start == null) { //첫 연결인 경우
			if (choice == 1) {//choice값에 따라 객체를 생성
				start = new Line(); //Line 객체 연결
				end = start;
			}
			else if (choice == 2) {
				start = new Rect2(); //Rect2 객체 연결
				end = start;
			}
			else if (choice == 3) {
				start = new Circle2(); //Circle2 객체 연결
				end = start;
			}
		}
		else {
			Shape obj;
			if (choice == 1) {
				obj = new Line();
				end.setNext(obj);
				end = obj;
			}
			else if (choice == 2) {
				obj = new Rect2();
				end.setNext(obj);
				end = obj;
			}
			else if (choice == 3) {
				obj = new Circle2();
				end.setNext(obj);
				end = obj;
			}
		}
		cnt++; //인덱스 포인터의 위치
	}
	
	public static void main(String [] args) {
		GraphicEditor ge = new GraphicEditor("beauty");
		ge.run();
	}
}
