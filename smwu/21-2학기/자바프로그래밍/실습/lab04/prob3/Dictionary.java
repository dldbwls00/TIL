// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 3. �߻� Ŭ���� �ǽ� - ����
package prob3;

class Dictionary extends PairMap{
	
	public Dictionary(int capacity) {//���� ����� �������� ������ ���� ���� ���� �� �ʱ�ȭ
		//capacity��ŭ�� �� �迭 ����
		keyArray = new String[capacity]; //key���� �����ϴ� �迭
		valueArray = new String[capacity]; //value���� �����ϴ� �迭
	}
	private int count = 0;//���� �迭�� ����� ���� 0���� �ʱ�ȭ

	String get(String key) {//key������ value�� �˻�
		
		for (int i=0; i<count; i++) {//���� �迭�� ����� ���� ������ŭ �ݺ��ϸ鼭
			if (keyArray[i].equals(key)) //key�� ���� ���� �ִ��� key�迭���� ã�Ƽ�
				return valueArray[i]; //�ش� value�� ��ȯ
		}
		return "null"; //key�� �߰��� �� ���ٸ� null ����
	}
	
	void put(String key, String value) {//key�� value�� ������ ����
		boolean exist = false;
		
		for (int i=0; i<count; i++) {//���� �迭�� ����� ���� ������ŭ �ݺ��ϸ鼭 
			if (keyArray[i].equals(key)){//key���� �̹� �迭�� ����Ǿ� �ִ� ���
				valueArray[i] = value;//�� ��ġ�� value�� ����
				exist = true;
				break;
			}
		}
		if (exist == false){//key���� �迭�� ����Ǿ� ���� ���� ���
			keyArray[count] = key; //���� �迭�� ���������� ����� ���� ������ key���� value�� ����
			valueArray[count] = value;
			count++; //���� �迭�� ����� ���� ����
		}
		
	}
	
	String delete(String key) {//key���� ���� ������(value�� �Բ�)�� ����, ������ value�� ����
		for (int i=0; i<count; i++) {//���� �迭�� ����� ���� ������ŭ �ݺ��ϸ鼭 
			if (keyArray[i].equals(key)) {//key���� �̹� �迭�� ����Ǿ� �ִ� ���
				String temp = valueArray[i];
				for (int j=i; j<count-i-1; j++) {//������ ��ġ�� �ڿ� �ִ� ���ҵ��� ������ �� ĭ�� �̵��ؾ���
					keyArray[j] = keyArray[j+1];
					valueArray[j] = valueArray[j+1];
				}
				count--; //���� �迭�� ����� ���� ����
				return temp;//	value�� ��ȯ
			}
		}
		return "null"; //key���� �迭�� ����Ǿ� ���� ���� ��� null ��ȯ
	}
	int length() {//���� ����� �������� ���� ����
		return count;
	}
}
