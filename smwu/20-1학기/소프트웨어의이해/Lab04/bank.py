print("="*40, "\n          은행 ATM        ")
print("="*40)
name=input("계좌 소유자의 이름을 입력해주세요 : ")

account=100000
selection = 0
while selection != 4:
    print("1. 입금")
    print("2. 출금")
    print("3. 잔액확인")
    print("4. 종료")
    print("="*40)
    
    selection = int(input("메뉴 선택 : "))
    if selection == 1:
        moneyin=int(input("입금할 금액을 입력해주세요 : "))
        print("\n")
        print("%d원이 성공적으로 입금되었습니다." % moneyin)
        print("\n")
        print("="*40, "\n          은행 ATM        ")
        print("="*40)
        
        account = account + moneyin
        
    elif selection == 2:
        moneyout=int(input("출금할 금액을 입력해주세요 : "))
        print("\n")
        if moneyout<=0:
            print("정확한 금액을 입력해주세요.")
            print("\n")
            print("="*40, "\n          은행 ATM        ")
            print("="*40)
            
        elif moneyout>account:
            print("잔액 부족. 거래 거절되었습니다.")
            print("\n")
            print("="*40, "\n          은행 ATM        ")
            print("="*40)
           
        else:
            print("%d원이 성공적으로 인출되었습니다." % moneyout)
            print("\n")
            print("="*40, "\n          은행 ATM        ")
            print("="*40)
            
            account = account - moneyout
            
    elif selection == 3:
        print("\n")
        print("%s님의 현재 잔액은 %d원입니다." % (name, account))
        print("\n")
        print("="*40, "\n          은행 ATM        ")
        print("="*40)
        
    else:
        print("\n")
        print("이용해주셔서 감사합니다.")
        break
print("프로그램 종료")
