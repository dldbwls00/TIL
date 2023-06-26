//이유진 (2016133)
//2023-06-26
//Lab0626-5: MyDate 클래스를 이용해 입력받은 년, 월, 일 정보를 날짜 형식으로 출력함

import java.util.Scanner;

class MyDate {

	// 필드 선언
	private int year;
	private int month;
	private int day;

	// 생성자 정의
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	// 접근자, 설정자
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	// printDate1() 정의
	public void printDate1() {
		System.out.println(year + "." + month + "." + day);
	}

	// printdate2() 정의
	public void printDate2() {
		String[] engMonth = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", 
				"Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		System.out.println(engMonth[month - 1] + " " + day + "," + year);
	}
}

public class DateTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("연도: ");
		int y = sc.nextInt();
		System.out.print("월: ");
		int m = sc.nextInt();
		System.out.print("일: ");
		int d = sc.nextInt();

		MyDate date = new MyDate(y, m, d); //MyDate 객체 선언 후 생성
		date.printDate1();
		date.printDate2();

		sc.close();
	}

}
