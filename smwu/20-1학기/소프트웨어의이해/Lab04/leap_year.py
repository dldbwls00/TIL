year=int(input("연도를 입력하세요 : "))

if year%4==0:
    if year%400==0:
        print("%d년은 윤년입니다." % year)
    elif year%100==0:
        print("%d년은 윤년이 아닙니다." % year)
    else:
        print("%d년은 윤년입니다." % year)
else:
    print("%d년은 윤년이 아닙니다." % year)
