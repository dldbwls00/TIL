class Account:
    def __init__(self, name, balance):
        self.owner=name
        self.balance=balance

    def deposit(self, amount):
        self.balance=self.balance+amount

    def withdraw(self, amount):
        self.balance=self.balance-amount

    def print_account(self):
        outputline=self.balance
        return outputline

def printmenu():
    print("**************************************")
    print("          Sookmyung Bank ATM          ")
    print("**************************************")
    print("          1. 잔액확인                  ")
    print("          2. 입금                      ")
    print("          3. 출금                      ")
    print("          4. 종료                      ")
    print("**************************************")
    print()
    global menu
    menu=int(input("메뉴를 선택해주세요 >>> "))
    print()
    
name=input("계좌 소유자의 이름을 입력해주세요 : ")
acc=Account(name, 0)
while True:
    print()
    printmenu() 
    
    if menu==1:
        print("계좌 소유자 : %s" % name)
        print("현재잔액 : %s" % (acc.print_account()))
        continue
    
    elif menu==2:
        while True:
            put=int(input("입금할 금액을 입력해주세요 : "))
            if (put<0):
                print("정확한 금액을 입력해주세요.")
                break
            else:
                print("%d원이 성공적으로 입금되었습니다." % (put))
                acc.deposit(put)
                break
        continue
    
    elif menu==3:
        
        while True:
            out=int(input("출금할 금액을 입력해주세요 : "))
            if (out<0):
                print("정확한 금액을 입력해주세요.")
                break
            elif (out>int(acc.print_account())):
                print("잔액 부족. 거래 거절되었습니다.")
                break
            else:
                print("%d원이 성공적으로 인출되었습니다." % (out))
                acc.withdraw(out)
                break
        continue
    
    elif menu==4:
        print("이용해주셔서 감사합니다.")
        break
    
    else:
        print("메뉴를 다시 선택해주세요")
        print()
        
