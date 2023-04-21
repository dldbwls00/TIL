// 이유진 (2016133)
// 2021-09-17
// Lab02 - 실습 3. 돈의 액수를 입력받아 환산하기
import java.util.Scanner;

public class ChangeMoney {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("금액을 입력하시오>>");
		int n = scanner.nextInt(); //정수 금액 입력받기
		
		int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; //환산할 돈의 종류를 담은 배열
		
		for (int i=0; i<unit.length; i++) {
			if (n/unit[i] > 0) { //금액을 해당 돈으로 환산할 수 있는 경우 -> 몫이 존재함
				System.out.println(unit[i]+"원 짜리 : " + n/unit[i] + "개");
				n %= unit[i]; //금액을 해당 돈으로 환산하면 나머지만 남음
			}
		}
		scanner.close();
	}

}
