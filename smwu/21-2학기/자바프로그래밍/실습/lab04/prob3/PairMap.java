// ������ (2016133)
// 2021-10-01
// Lab04 - �ǽ� 3. �߻� Ŭ���� �ǽ� - ����
package prob3;

abstract class PairMap {
	protected String keyArray[]; //key���� �����ϴ� �迭
	protected String valueArray[]; //value���� �����ϴ� �迭
	abstract String get(String key); //key������ value�� �˻�
	abstract void put(String key, String value); //key�� value�� ������ ����
	abstract String delete(String key); //key���� ���� ������(value�� �Բ�)�� ����, ������ value�� ����
	abstract int length(); //���� ����� �������� ���� ����
}
