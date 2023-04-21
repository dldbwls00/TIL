print("======Sookmyung Cafe======")
print("    1. 아메리카노 1800원")
print("    2. 카페라떼 2200원")
print("    3. 카페모카 2800원")
print("==========================")
print("\n")

menu=[] #메뉴
number=[] #잔 수(menu리스트와 동일한 순서)
time=0 #주문한 횟수
totalnum=0 #총 몇 잔인지
totalprice=0 #총 금액

while True:
    select=int(input("메뉴를 선택해주세요 >>> "))
    if select==1:
        pass
    elif select==2:
        pass
    elif select==3:
        pass
    else:
        print("메뉴를 다시 선택해주세요")
        continue
    
    num=int(input("몇 잔을 주문하시겠습니까?? >>> "))
    more=input("주문을 계속하시겠습니까? (Y/N) >>> ")
    
    if more=='Y' or more=='y':
        print("\n")
        if select==1:
            menu.append("아메리카노")
        elif select==2:
            menu.append("카페라떼")
        elif select==3:
            menu.append("카페모카")
        number.append(num)
        time=time+1
        continue
    
    elif more=='N' or more=='n':
        print("\n")
        if select==1:
            menu.append("아메리카노")
        elif select==2:
            menu.append("카페라떼")
        elif select==3:
            menu.append("카페모카")
        number.append(num)
        time=time+1
        print("=====주 문 내 역=====")
        
        for i in range(0,time):
            print("   ",menu[i],number[i],"잔")
            
        print("\n")
        
        for j in number:
            totalnum = totalnum+int(j)

        for k in range(0,time):
            if menu[k]=="아메리카노":
                totalprice=totalprice+1800*int(number[k])
            elif menu[k]=="카페라떼":
                totalprice=totalprice+2200*int(number[k])
            elif menu[k]=="카페모카":
                totalprice=totalprice+2800*int(number[k])
            
        print("==총",totalnum,"잔,",totalprice,"원==")
        print("\n")
        print("이용해주셔서 감사합니다")
        break
    
