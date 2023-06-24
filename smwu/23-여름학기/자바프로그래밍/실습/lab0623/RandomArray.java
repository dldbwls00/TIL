//이유진 (2016133)
//2023-06-23
//Lab0623-4: 3*5 크기의 2차원 배열에 5개의 1을 랜덤 배치

public class RandomArray {

	public static void main(String[] args) {

		// 3*5 크기의 2차원 배열 선언 후 0으로 초기화 (생성 초기값이 0이므로)
		int[][] arr = new int[3][5];
		
		int cnt = 0; // 저장된 1의 개수

		while (true) {
			if (cnt == 5) // 1의 개수가 5라면 반복문 종료
				break;

			int row = (int) (Math.random() * 10) % 3; // 행 인덱스 랜덤 생성
			int col = (int) (Math.random() * 10) % 5; // 열 인덱스 랜덤 생성

			if (arr[row][col] != 0) // 이미 1이 저장된 경우
				continue; // 건너뜀
			else {// 요소가 0인 경우 (1이 저장되지 않음)
				arr[row][col] = 1; // 1 저장
				cnt++;
			}
		}

		for (int i = 0; i < arr.length; i++) { // 배열 출력
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}
