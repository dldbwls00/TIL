//이유진 (2016133)
//2023-06-27
//Lab0627-1: BankAccount 클래스를 이용해 입출금/계좌이체 기능을 구현함: 매개변수로 객체참조변수 전달 실습

import java.util.Scanner;

class BankAccount {
	private int balance = 0; //잔액

	// 생성자
	public BankAccount(int balance) {
		super();
		this.balance = balance;
	}

	// 설정자, 접근자 대신 입/출금, 이체 메소드 사용
	
	void withdraw(int m) { // 출금
		if (m <= 0) // 매개변수로 들어온 금액이 양수일 때만 처리
			System.out.println("적절하지 않은 출금 금액!");
		else {
			if (this.balance >= m) // 출금
				this.balance -= m;
			else // 잔액 부족: 매개변수로 들어온 금액보다 잔액이 크거나 같을 때만 출금 처리
				System.out.println("잔액 부족!");
		}
	}

	void deposit(int m) { // 입금
		if (m <= 0) // 매개변수로 들어온 금액이 양수일 때만 처리
			System.out.println("적절하지 않은 입금 금액!");
		else 
			this.balance += m; // 입금
	}

	public void transfer(int amount, BankAccount otherAccount) { // 계좌간 이체
		if (amount <= 0) // 매개변수로 들어온 금액이 양수일 때만 처리
			System.out.println("적절하지 않은 이체 금액!");
		else {
			if (this.balance >= amount) { //현재 계좌에서 amount만큼을 빼고 다른 계좌에 amount만큼을 더함
				this.balance -= amount;
				otherAccount.balance += amount;
			}
			else // 잔액 부족
				System.out.println("잔액 부족!");
		}
	}

	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + "]";
	}
}

public class BankAccountTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("계좌 1 잔액 입력: ");
		int a1 = scan.nextInt();
		BankAccount myAccount1 = new BankAccount(a1);
		System.out.print("계좌 2 잔액 입력: ");
		int a2 = scan.nextInt();
		BankAccount myAccount2 = new BankAccount(a2);

		System.out.println("myAccount1: " + myAccount1);
		System.out.println("myAccount2: " + myAccount2);
		System.out.println();

		System.out.print("계좌 1 --> 계좌 2 이체 금액 입력: ");
		int t = scan.nextInt();
		myAccount1.transfer(t, myAccount2);
		System.out.println("transfer 호출 후");
		System.out.println("myAccount1: " + myAccount1);
		System.out.println("myAccount2: " + myAccount2);

		scan.close();
	}

}
