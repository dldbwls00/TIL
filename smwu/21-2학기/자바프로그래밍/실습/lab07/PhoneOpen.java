// 이유진 (2016133)
// 2021-10-22
// Lab07 - 실습 1. 연락처 정보 저장 및 출력
import java.io.FileReader;
import java.io.IOException;

public class PhoneOpen {

	public static void main(String[] args) throws IOException {
		FileReader fin = null; //file reader를 이용한 파일 읽기
		System.out.println("c:\\temp\\phone.txt를 출력합니다.");

		fin = new FileReader("c:\\temp\\phone.txt");
		int c;
		while ((c = fin.read()) != -1) //파일 끝까지 바이트씩 c에 읽어들임
			System.out.print((char)c); //바이트 c를 문자로 변환하여 화면에 출력
		
		fin.close(); //스트림과 파일 닫기 -> 연결 끊김
	}

}
