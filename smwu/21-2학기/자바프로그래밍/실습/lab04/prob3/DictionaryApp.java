// 이유진 (2016133)
// 2021-10-01
// Lab04 - 실습 3. 추상 클래스 실습 - 사전
package prob3;

public class DictionaryApp {

	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("김숙명", "자바"); 
		dic.put("이순헌", "파이썬"); 
		dic.put("이순헌", "c++"); //이순헌의 value 변경
		dic.put("정명신", "react"); 
		System.out.println("이순헌의 값은 "+dic.get("이순헌"));
		System.out.println("김숙명의 값은 "+dic.get("김숙명"));
		dic.delete("김숙명");
		System.out.println("김숙명의 값은 "+dic.get("김숙명"));
		System.out.println("정명신의 값은 "+dic.get("정명신"));
	}

}
