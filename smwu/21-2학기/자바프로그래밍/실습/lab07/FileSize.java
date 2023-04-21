// 이유진 (2016133)
// 2021-10-22
// Lab07 - 실습 4. 크기가 가장 큰 파일 찾기
import java.io.*;

public class FileSize {

	public static void main(String[] args) {
		File dir = new File("c:\\"); //파일 객체 생성: 디렉터리로
		File[] subfiles = dir.listFiles(); //서브파일들 담기
		
		long max = 0; //최댓값을 찾기 위함
		String maxname = null;
		for (int i=0; i<subfiles.length; i++) {
			File f = subfiles[i];
			if (f.length() > max) { //최대 용량 찾기
				max = f.length();
				maxname = f.getName();
			}
		}
		System.out.println("가장 큰 파일은 c:\\" + maxname + " " + max + "바이트");
	}

}
