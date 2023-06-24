//이유진 (2016133)
//2023-06-23
//Lab0623-3: 각 변의 길이가 20보다 작은 삼각형 중 피타고라스 정리를 만족하는 3개 정수 찾기

public class Pythagoras {

	public static void main(String[] args) {

		int i, j, k; // 삼각형의 각 변

		for (i = 1; i <= 20; i++) { // 삼중 for문 이용
			for (j = 1; j <= 20; j++) {
				for (k = 1; k <= 20; k++) {
					// 삼각형의 성립조건: 두 변 길이의 합이 다른 한 변의 길이보다 커야함
					// 피타고라스 정리: i^2 + j^2 = k^2
					if ((i * i + j * j == k * k) 
							&& ((i + j > k) || (j + k > i) || (k + i > j)))
						System.out.println(i + " " + j + " " + k);
				}
			}
		}
	}

}
