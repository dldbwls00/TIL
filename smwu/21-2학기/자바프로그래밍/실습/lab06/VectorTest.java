// 이유진 (2016133)
// 2021-10-08
// Lab06 - 실습 1. 벡터 실습

import java.util.Scanner;
import java.util.Vector;

public class VectorTest {
	public static void printVector(Vector<Integer> v) { //벡터를 매개변수로 받는 메소드
		System.out.print("[");
		for (int i=0; i<v.size()-1; i++)	System.out.print(v.get(i) + ", ");
		System.out.print(v.get(v.size()-1));
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //scanner 객체
		Vector<Integer> v = new Vector<Integer>(); //vector 객체
		
		int max = 0;
		System.out.print("정수(-1이 입력될 때까지)>> "); //출력문
		while (true) {//반복문
			int n = scanner.nextInt();
			if (n == -1)	break; //-1이 입력될 때 반복문을 빠져나옴
			v.add(n); //벡터에 입력 정수 저장
			if (n > max)	max = n; //가장 큰 수 찾기
		}
		
		System.out.print("삭제 전:"); //출력문 1
		printVector(v);
		
		System.out.println("가장 큰 수 "+ max + " 삭제"); //삭제 메시지
		v.remove(v.indexOf(max)); //삭제
		
		printVector(v); //출력문 2
	
		int min = v.get(0);
		for (int i=0; i<v.size(); i++){//가장 작은 수 찾기
			if (v.get(i) < min)	min = v.get(i);
		}
		System.out.println("가장 작은 수 "+ min + " 삭제"); //삭제 메시지
		v.remove(v.indexOf(min)); //삭제
		
		System.out.print("삭제 후:"); //출력문 3
		printVector(v);
		
		scanner.close();
	}

}
