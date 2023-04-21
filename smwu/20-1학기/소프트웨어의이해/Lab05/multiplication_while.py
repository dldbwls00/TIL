num=int(input("숫자를 입력해주세요 : "))
i=0

while i<num:
    i+=1
    if i%2==0 and i%3==0:
        continue
    else:
        print(i)
