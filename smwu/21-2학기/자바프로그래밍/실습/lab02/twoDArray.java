// ������ (2016133)
// 2021-09-17
// Lab02 - �ǽ� 5. 4x4 �������迭�� 10 ���� ���� ���� 10�� ���� �����ϱ�
public class twoDArray {

	public static void main(String[] args) {
		int arr[][] = new int[4][4]; //4x4 2���� �迭 ����
		
		for(int i=0; i<arr.length; i++) {//�迭�� ��� ���Ҹ� 0���� �ʱ�ȭ
			for(int j=0; j<arr[i].length; j++)
				arr[i][j]=0;
		}
		
		int cnt = 0; //������ ���� ���� 
		while(cnt<10) {
			int r = (int)(Math.random()*10+1); //1~10�� ������ �����ϰ� ����
		
			int x = (int)(Math.random()*4);//�迭�� �� �ε��� �����ϰ� ���� (0, 1, 2, 3)
			int y = (int)(Math.random()*4);//�迭�� �� �ε��� �����ϰ� ����
			
			if (arr[x][y]!=0) //�迭�� ���Ұ� 0�� �ƴϸ� �̹� ���� ����� �����̹Ƿ� �ǳʶ�
				continue;
			
			arr[x][y] = r; //�׷��� �ʴٸ�(�ش� ��ġ�� ���Ұ� 0�̶��) ���� ���� 1~10 ����
			cnt++; //������ ���� ���� ����
		}
	
		for(int i=0; i<arr.length; i++) {//2���� �迭 ���
			for(int j=0; j<arr[i].length; j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
		
	}

}
