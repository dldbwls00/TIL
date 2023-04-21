// 이유진 (2016133)
// 2021-10-08
// Lab06 - 실습 5. 영어 단어 테스트 프로그램

public class Word {
	private String eng, kor;
	
	public Word(String eng, String kor) {//생성자
		this.eng = eng;
		this.kor = kor;
	}
	
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	
}
