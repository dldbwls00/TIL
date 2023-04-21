num=int(input("숫자를 입력해주세요 : "))

for i in range(1,num+1):
    if i%2==0 and i%3==0:
        continue
    else:
        print(i)
