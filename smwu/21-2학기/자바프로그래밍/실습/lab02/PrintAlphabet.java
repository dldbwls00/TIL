// ������ (2016133)
// 2021-09-17
// Lab02 - �ǽ� 2. ���ĺ� �Է¹ް� ���ڿ� ����ϱ�
import java.util.Scanner;

public class PrintAlphabet {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�ҹ��� ���ĺ� �ϳ��� �Է��Ͻÿ�>> ");
		String alphabet = scanner.next(); //Scanner�� ���ڸ� �Է¹޴� ����� �����Ƿ� ���ڿ��� �Է¹���
		char c = alphabet.charAt(0); //���ڿ��� ù ��° ����
		
		for(; c>='a'; c--) { //a���� �Է¹��� ���� c������ ����ϸ� �����ں��� �ϳ��� �ٿ����Ƿ�, c�� 1�� ���ҽ�Ų��.
			for(char s = 'a'; s<=c; s++) //a���� �Է¹��� ���� c���� ����Ѵ�.
				System.out.print(s);
			System.out.println(); //�ٹٲ�
		}
		scanner.close();
	}

}
