// 이유진 (2016133)
// 2021-10-08
// Lab06 - 실습 5. 영어 단어 테스트 프로그램

import java.util.Scanner;
import java.util.Vector;

public class WordTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //scanner 객체
		Vector<Word> v = new Vector<Word>(); //vector 객체
		v.add(new Word("love", "사랑")); //17개의 Word 객체 삽입
		v.add(new Word("animal", "동물"));
		v.add(new Word("emotion", "감정"));
		v.add(new Word("human", "인간"));
		v.add(new Word("stock", "주식"));
		v.add(new Word("trade", "거래"));
		v.add(new Word("society", "사회"));
		v.add(new Word("baby", "아기"));
		v.add(new Word("honey", "꿀"));
		v.add(new Word("doll", "인형"));
		v.add(new Word("bear", "곰"));
		v.add(new Word("picture", "사진"));
		v.add(new Word("painting", "그림"));
		v.add(new Word("fault", "오류"));
		v.add(new Word("example", "보기"));
		v.add(new Word("eye", "눈"));
		v.add(new Word("statue", "조각상"));
		
		System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.\n"
				+ "현재 " + v.size() + "개의 단어가 들어 있습니다.");
		while (true) {
			int n = (int)(Math.random()*v.size()); //0 ~ 벡터size() 사이의 랜덤 정수
			System.out.println(v.get(n).getEng() + "?");
			
			int one, three, four;
			while(true) {
				one = (int)(Math.random()*v.size());
				three = (int)(Math.random()*v.size());
				four = (int)(Math.random()*v.size());
				if (one==n || three==n || four==n)
					continue; //보기에 같은 단어가 나오지 않게 하기 위함
				break;
			}
			System.out.print("(1)"+v.get(one).getKor()
					+" (2)"+v.get(n).getKor()
					+" (3)"+v.get(three).getKor()
					+" (4)"+v.get(four).getKor()+ " :>");
			
			int ans = scanner.nextInt(); //정답 입력받기
			if (ans == -1) { //-1을 입력할 경우 종료
				System.out.println("\"명품영어\"를 종료합니다...");
				break;
			}
			if (ans == 2) //결과 출력 : 정답(2번 선지)를 입력한 경우
				System.out.println("Excellent!"); 
			else System.out.println("No. !!"); //오답을 입력한 경우
		}
		
		scanner.close();
	}

}
