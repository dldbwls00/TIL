// 이유진 (2016133)
// 2021-10-22
// Lab07 - 실습 1. 연락처 정보 저장 및 출력
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneSave {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in); //스캐너 객체
		FileWriter fout = null; //키보드 입력을 파일로 저장하기 위함
		System.out.println("전화번호 입력 프로그램입니다.");

		fout = new FileWriter("c:\\temp\\phone.txt"); // fout의 위치와 함께 파일 생성
		while(true) {
			System.out.print("이름 전화번호 >> ");
			String in = scanner.nextLine();
			
			if (in.equals("그만"))	break;
			if (in.length() == 0)	break; //입력이 없는 경우 -> 줄바꿈
			fout.write(in, 0, in.length()); //문자들만 저장됨
			fout.write("\r\n", 0, 2); //한 줄 띄기
		}
		System.out.println("c:\\temp\\phone.txt에 저장하였습니다.");
		fout.close();
		scanner.close();
	}

}
