// 이유진 (2016133)
// 2021-09-17
// Lab02 - 실습 1. 이차원배열 n 출력하기
public class Print2DArray {

	public static void main(String[] args) {
		
		int n[][] = {{1}, {1,2,3}, {1}, {1,2,3,4}, {1,2}}; //2차원 배열 선언, 생성, 초기화
		
		for (int i=0; i<n.length; i++) {
			for (int j=0; j<n[i].length; j++) //비정방 배열의 출력
				System.out.print(n[i][j] + "\t");
			System.out.println(); //행 구분
		}
		
	}

}
