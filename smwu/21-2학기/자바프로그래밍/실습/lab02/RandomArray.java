// 이유진 (2016133)
// 2021-09-17
// Lab02 - 실습 4. 정수의 개수 입력받아 정수 배열에 겹치지 않게 랜덤 삽입하기
import java.util.Scanner;

public class RandomArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //스캐너 객체 생성
		
		System.out.print("정수 몇개? "); //사용자로부터 입력을 받기 위한 출력문
		
		int n;
		while(true) {//입력받은 값의 유효성 체크하기 위한 while문
			n = scanner.nextInt(); //스캐너를 통한 입력값 저장
			if (n>100 || n<0) {
				System.out.print("유효하지 않은 값입니다. 다시 입력하세요 >> ");
				continue;
			}
			else break;
		}
		
		int arr[] = new int[n]; //배열 선언, 입력받은 크기만큼 배열 생성
		
		int cnt = 0;
		while(cnt<n) { //배열의 크기만큼 반복
			int r = (int)(Math.random()*100+1); //1~100의 정수를 랜덤하게 생성
			
			for (int i=0; i<arr.length; i++) {//정수 r이 이미 배열 arr[0]~arr[i-1]에 있는지 검사
				if (r == arr[i]){ //정수 r이 이미 배멸 arr안에 있는 경우
					r = 999;
					break;
				}
			}
	 		if (r == 999)	continue; //랜덤정수를 다시 입력받기 위해 continue
	 		
	 		arr[cnt] = r; //r이 arr안에 없는 경우 저장
	 		cnt++;
		}
		
		for (int j=0; j<arr.length; j++) { //배열을 화면에 출력
			System.out.print(arr[j]+" ");
			if ((j+1)%10 == 0) System.out.println(); //한 줄에 10개씩 출력하기 위해
		}
		scanner.close();
	}

}
