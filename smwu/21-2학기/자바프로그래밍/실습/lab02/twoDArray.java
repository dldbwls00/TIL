// 이유진 (2016133)
// 2021-09-17
// Lab02 - 실습 5. 4x4 이차원배열에 10 이하 양의 정수 10개 랜덤 생성하기
public class twoDArray {

	public static void main(String[] args) {
		int arr[][] = new int[4][4]; //4x4 2차원 배열 생성
		
		for(int i=0; i<arr.length; i++) {//배열의 모든 원소를 0으로 초기화
			for(int j=0; j<arr[i].length; j++)
				arr[i][j]=0;
		}
		
		int cnt = 0; //생성된 숫자 갯수 
		while(cnt<10) {
			int r = (int)(Math.random()*10+1); //1~10의 정수를 랜덤하게 생성
		
			int x = (int)(Math.random()*4);//배열의 행 인덱스 랜덤하게 생성 (0, 1, 2, 3)
			int y = (int)(Math.random()*4);//배열의 열 인덱스 랜덤하게 생성
			
			if (arr[x][y]!=0) //배열의 원소가 0이 아니면 이미 값이 저장된 원소이므로 건너뜀
				continue;
			
			arr[x][y] = r; //그렇지 않다면(해당 위치의 원소가 0이라면) 랜덤 숫자 1~10 저장
			cnt++; //생성된 숫자 개수 증가
		}
	
		for(int i=0; i<arr.length; i++) {//2차원 배열 출력
			for(int j=0; j<arr[i].length; j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
		
	}

}
