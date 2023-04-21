name=input("이름을 입력하세요 : ")
call=float(input("음성 통화 시간(초)를 입력하세요 : "))
data=float(input("데이터 사용량(MB)을 입력하세요 : "))
cost=12100 + 1.98*call + 55*data
print(name, "님의 이용 요금입니다:", cost)
