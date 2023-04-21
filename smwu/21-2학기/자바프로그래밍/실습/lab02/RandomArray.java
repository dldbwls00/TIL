// ������ (2016133)
// 2021-09-17
// Lab02 - �ǽ� 4. ������ ���� �Է¹޾� ���� �迭�� ��ġ�� �ʰ� ���� �����ϱ�
import java.util.Scanner;

public class RandomArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //��ĳ�� ��ü ����
		
		System.out.print("���� �? "); //����ڷκ��� �Է��� �ޱ� ���� ��¹�
		
		int n;
		while(true) {//�Է¹��� ���� ��ȿ�� üũ�ϱ� ���� while��
			n = scanner.nextInt(); //��ĳ�ʸ� ���� �Է°� ����
			if (n>100 || n<0) {
				System.out.print("��ȿ���� ���� ���Դϴ�. �ٽ� �Է��ϼ��� >> ");
				continue;
			}
			else break;
		}
		
		int arr[] = new int[n]; //�迭 ����, �Է¹��� ũ�⸸ŭ �迭 ����
		
		int cnt = 0;
		while(cnt<n) { //�迭�� ũ�⸸ŭ �ݺ�
			int r = (int)(Math.random()*100+1); //1~100�� ������ �����ϰ� ����
			
			for (int i=0; i<arr.length; i++) {//���� r�� �̹� �迭 arr[0]~arr[i-1]�� �ִ��� �˻�
				if (r == arr[i]){ //���� r�� �̹� ��� arr�ȿ� �ִ� ���
					r = 999;
					break;
				}
			}
	 		if (r == 999)	continue; //���������� �ٽ� �Է¹ޱ� ���� continue
	 		
	 		arr[cnt] = r; //r�� arr�ȿ� ���� ��� ����
	 		cnt++;
		}
		
		for (int j=0; j<arr.length; j++) { //�迭�� ȭ�鿡 ���
			System.out.print(arr[j]+" ");
			if ((j+1)%10 == 0) System.out.println(); //�� �ٿ� 10���� ����ϱ� ����
		}
		scanner.close();
	}

}
