// 이유진 (2016133)
// 2021-09-10
// Lab01 - 실습 4. 369게임
import java.util.Scanner;

public class Lab1_6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("1~99 사이의 정수를 입력하시오>>");
		int num = scanner.nextInt(); //정수 입력받기 
		
		int ten = num / 10; //십의 자리 따로 저장
		int one = num % 10; //일의 자리 따로 저장
		
		System.out.print("박수");
		if (ten==3 || ten==6 || ten==9)	System.out.print("짝"); //십의 자리가 3,6,9인 경우
		if (one==3 || one==6 || one==9)	System.out.print("짝"); //일의 자리가 3,6,9인 경우
		if (ten!=3 && ten!=6 && ten!=9 && one!=3 && one!=6 && one!=9) System.out.println("없음"); //3,6,9가 한 개도 없는 경우
	}

}
