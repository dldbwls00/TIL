// 이유진 (2016133)
// 2021-10-22
// Lab07 - 실습 3. 텍스트 파일 복사하여 붙이기
import java.io.*;
import java.util.Scanner;

public class FileAppend {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("첫번째 파일 이름을 입력하세요>>");
		File name1 = new File(scanner.next()); //첫 번째 파일 객체 생성
		FileReader fr1 = new FileReader(name1); //읽어오기
		
		System.out.print("두번째 파일 이름을 입력하세요>>");
		File name2 = new File(scanner.next()); //두 번째 파일 객체 생성
		FileReader fr2 = new FileReader(name2); //읽어오기
		
		System.out.print("합치는 파일 이름을 입력하세요>>");
		File newname = new File(scanner.next()); //합치는 파일 객체 생성
		FileWriter fw = new FileWriter(newname); //파일로부터 입력받아 생성하기 위함
		
		int c;
		while((c = fr1.read()) != -1)	fw.write((char)c); //문자 하나 읽고 하나 쓰고
		fw.write("\n"); 
		while((c = fr2.read()) != -1)	fw.write((char)c);
		
		System.out.println("프로젝트 폴더 밑에 c.txt 파일에 저장하였습니다.");
		scanner.close();
		fr1.close(); 
		fr2.close(); 
		fw.close();
	}

}
