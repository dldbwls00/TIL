// ������ (2016133)
// 2021-09-17
// Lab02 - �ǽ� 1. �������迭 n ����ϱ�
public class Print2DArray {

	public static void main(String[] args) {
		
		int n[][] = {{1}, {1,2,3}, {1}, {1,2,3,4}, {1,2}}; //2���� �迭 ����, ����, �ʱ�ȭ
		
		for (int i=0; i<n.length; i++) {
			for (int j=0; j<n[i].length; j++) //������ �迭�� ���
				System.out.print(n[i][j] + "\t");
			System.out.println(); //�� ����
		}
		
	}

}
