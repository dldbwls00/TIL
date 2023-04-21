// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 3. 추상 클래스 실습 - 사전
package prob3;

abstract class PairMap {
	protected String keyArray[]; //key들을 저장하는 배열
	protected String valueArray[]; //value들을 저장하는 배열
	abstract String get(String key); //key값으로 value를 검색
	abstract void put(String key, String value); //key와 value를 쌍으로 저장
	abstract String delete(String key); //key값을 가진 아이템(value와 함께)을 삭제, 삭제된 value값 리턴
	abstract int length(); //현재 저장된 아이템의 개수 리턴
}
