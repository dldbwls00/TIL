def print_menu():
    global select
    print("=======Sookmyung Cafe======")
    print("  1. 커피 메뉴 선택")
    print("  2. 주문 내역 확인")
    print("  3. 결제")
    print("  4. 잔돈 계산")
    print("===========================")
    print()
    select=input("메뉴를 선택해주세요 >>> ")
    print()

def print_coffeeMenu():
    print("[Cafe Menu]")
    for i in menu:
        print(i, " ", menu[i], "원", sep='')
    print()
    
def select_menu(menu, cup):
    while True:
        menuselect=input("메뉴를 입력해주세요 (엔터입력시종료) >>> ")
        if menuselect=='':
            break
        if menuselect not in menu:
            print("메뉴를 다시 입력해주세요")
            continue
        else:
            menunum=input("몇 잔을 주문하시겠습니까? >>> ")
        
        if menuselect in cup:
            cup[menuselect]=str(int(cup[menuselect])+int(menunum))
        else:
            cup[menuselect]=menunum
    print()
            
def check_order():
    for i in cup:
        print(i, "   ", cup[i], "잔")
    print()
        
def calculate_price():
    price=0
    for i in cup:
        if i=='아메리카노':
            price=price+int(cup[i])*1800
        elif i=='카페라떼':
            price=price+int(cup[i])*2200
        elif i=='카페모카':
            price=price+int(cup[i])*2800
    print("합계 :", price)
    while True:
        money=int(input("지불할 돈 : "))
        if money<price:
            print(price, "원 이상의 돈을 지불하세요")
        else:
            print("지불완료")
            global change
            change=money-price
            break
    return change
    print()
    
def get_change(change):
    print("잔돈은", change, "원 입니다")
    print("===========================")
    a=change//5000
    b=(change%5000)//1000
    c=(change%1000)//500
    d=(change%500)//100
    print("5000원 :", a)
    print("1000원 :", b)
    print("500원 :", c)
    print("100원 :", d)
    print()
    print("이용해주셔서 감사합니다")


cup={}
menu={"아메리카노":1800, "카페라떼":2200, "카페모카":2800}
while True:
    print_menu()
    
    if (select=='1'):
        print_coffeeMenu()
        select_menu(menu, cup)
        continue
    elif (select=='2'):
       check_order()
       continue
    elif (select=='3'):
        calculate_price()
        continue
    elif (select=='4'):
        get_change(change)
        break
