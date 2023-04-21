# 컴퓨터과학과 2016133 이유진
print("컴퓨터과학과 2016133 이유진")
print()
import time
n=time.localtime(time.time()) 

from datetime import date
#살아온 날을 계산하기 위해 불러온 모듈: date(현재날짜)-date(태어난 날짜)

def enter():
    global year, month, day, hour, minute
    print("현재의 날짜와 시간은 %d년 %d월 %d일 %d시 %d분 입니다." \
          %(n.tm_year, n.tm_mon, n.tm_mday, n.tm_hour, n.tm_min))
    print()
    print("생년일시를 입력하세요!")
    year=int(input("태어난 년도: "))
    month=int(input("태어난 달: "))
    day=int(input("태어난 날: "))
    hour=int(input("태어난 시(24시간, 모르면 0): "))
    minute=int(input("태어난 분(모르면 0): "))
    print()
    print("다음 중 살아온 시간을 어떤 형식으로 보겠습니까?")
    print("1. 일")
    print("2. 시")
    print("3. 분")
    print("4. 보기 끝")
    
def leapYear(y):
    #윤년 계산
    #4의 배수이면서 100의 배수가 아니지만 400의 배수일 때 윤년(2월이 29일까지)
    if y%4==0:
        if y%100==0:
            if y%4==400:
                return 0 #윤년
            else:
                return 1
        else:
            return 1
    else:
        return 1

def dateSum(year, month, day): 
    #살아온 일 계산
    print()
    minus=date(n.tm_year, n.tm_mon, n.tm_mday)-date(year, month, day)
    return minus.days

while(True):
    enter()
    while(True):
        print()
        menu=int(input("메뉴를 선택하세요. "))
        print()
        if menu==1:
            print(dateSum(year, month, day), "일간 살았습니다.")
            continue
        elif menu==2:
            print(dateSum(year, month, day)*24, "시간 살았습니다.")
            continue
        elif menu==3:
            print(dateSum(year, month, day)*24*60, "분간 살았습니다.")
            continue
        elif menu==4:
            while(True):
                print()
                end=input("계속 하시겠습니까? (y/n)")
                if end=='y':
                    break
                elif end=='n':
                    break
                else:
                    print("잘못된 답입니다!")
                    print()
                    continue
            if end=='y':
                break
            elif end=='n':
                break
        else:
            print("잘못된 선택입니다.")
            print()
            continue
    if end=='y':
        print()
        continue
    elif end=='n':
        break

        
