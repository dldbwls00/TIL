// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 3. 추상 클래스 실습 - 사전
package prob3;

class Dictionary extends PairMap{
	
	public Dictionary(int capacity) {//현재 저장된 아이템의 개수를 위한 변수 선언 및 초기화
		//capacity만큼의 각 배열 생성
		keyArray = new String[capacity]; //key들을 저장하는 배열
		valueArray = new String[capacity]; //value들을 저장하는 배열
	}
	private int count = 0;//현재 배열에 저장된 개수 0으로 초기화

	String get(String key) {//key값으로 value를 검색
		
		for (int i=0; i<count; i++) {//현재 배열에 저장된 원소 개수만큼 반복하면서
			if (keyArray[i].equals(key)) //key와 같은 값이 있는지 key배열에서 찾아서
				return valueArray[i]; //해당 value값 반환
		}
		return "null"; //key를 발견할 수 없다면 null 리턴
	}
	
	void put(String key, String value) {//key와 value를 쌍으로 저장
		boolean exist = false;
		
		for (int i=0; i<count; i++) {//현재 배열에 저장된 원소 개수만큼 반복하면서 
			if (keyArray[i].equals(key)){//key값이 이미 배열에 저장되어 있는 경우
				valueArray[i] = value;//그 위치에 value값 저장
				exist = true;
				break;
			}
		}
		if (exist == false){//key값이 배열에 저장되어 있지 않은 경우
			keyArray[count] = key; //현재 배열에 마지막으로 저장된 원소 다음에 key값과 value값 저장
			valueArray[count] = value;
			count++; //현재 배열에 저장된 개수 증가
		}
		
	}
	
	String delete(String key) {//key값을 가진 아이템(value와 함께)을 삭제, 삭제된 value값 리턴
		for (int i=0; i<count; i++) {//현재 배열에 저장된 원소 개수만큼 반복하면서 
			if (keyArray[i].equals(key)) {//key값이 이미 배열에 저장되어 있는 경우
				String temp = valueArray[i];
				for (int j=i; j<count-i-1; j++) {//삭제된 위치의 뒤에 있는 원소들을 앞으로 한 칸씩 이동해야함
					keyArray[j] = keyArray[j+1];
					valueArray[j] = valueArray[j+1];
				}
				count--; //현재 배열에 저장된 개수 감소
				return temp;//	value값 반환
			}
		}
		return "null"; //key값이 배열에 저장되어 있지 않은 경우 null 반환
	}
	int length() {//현재 저장된 아이템의 개수 리턴
		return count;
	}
}
