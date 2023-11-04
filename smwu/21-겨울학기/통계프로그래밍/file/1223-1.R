###### 변수설정
# R 객체가 저장된 위치의 이름
## * 변수명은 영문자, 한글, .로 시작하고 이후 숫자, _ 사용가능
## * 일부 예약어는 사용할 수 없음
## - 예) if, for, while, TRUE, FALSE …
## * 대문자와 소문자 구분
## - 예) If, For, While, True, False는 변수명으로 사용가능
######
(X1 = 1.0) #/ 양옆으로 괄호를 씌우면 대입과 동시에 출력
1X = 1.0
.X = 1.0
한글X = 1.0
if = 0
If = 0
###### Assign Operators
# =, <-, ->
## * = : 오른쪽의 연산 값을 왼쪽의 변수에 할당(대입)
## * <- : 오른쪽의 연산 값을 왼쪽의 변수에 할당(대입)
## * -> : 왼쪽의 연산 값을 오른쪽의 변수에 할당(대입)
######
a = 15
b <- 15; 5 -> c # 한줄에 여러 명령어를 쓸 때에는 ;로 분리
a <- b <- c <- 6 # 동일 연산자 사용
(x <- 1/pi) # 대입결과를 출력하기
x <- c(1,2,3,4,5) # 'c()' 자료를 결합하여 벡터로 만드는 함수
# "R에서의 최소단위는 벡터"

1+6/2
(1+6)/2
2*3**2
(2*3)**2
12/3*4
12/(3*4)

###### Arithmetic Operators
# +, -, *, /, ^, **, %%(나머지), %/%(몫)
## * 연산순위: (^, **) > (%%, %/%) > (*, /) > (+, -)
## * ( ) 안의 내용을 우선 연산
## * 같은 우선 순위인 경우 왼쪽부터 먼저 실시
######
n <- 10+2
3^3
n <- (3+5)*3-4**2/3 # 연산의 우선순위
58 %% 3
58 %/% 3
# ?: 홀수/짝수 구분
x <- 0; y <- Inf # NA: Not Applicable/Available: 결측값(해당사항없음)
x*y # NaN: Not a Number
x/x
x <- c(1,2,3,4) ; y <- c(2,3,5,4) # 벡터연산
x+y
x <- c(1,2,3,4); y <- c(1,2) # 재활용규칙(recycling rule)
v <- x+y
x <- c(1,2,3,4,5)
w <- x+y




###### Logical Operators
# !, &, &&, |, ||, xor(x, y)
## * 결과는 TRUE, FALSE
## * TRUE는 T, FALSE는 F로 표시할 수 있음
## * TRUE는 T, FALSE는 F로 표시할 수 있음
## * TRUE는 1, FALSE는 0으로 처리
## * 0이면 FALSE, 0이 아닌 숫자(Inf 포함)는 TRUE로 처리
# &&, || : 결과가 여러 개인 경우 첫번째 것만 반영
######
x = TRUE; y = c(FALSE, TRUE)
!y
x & y
x && y
x | y
x || y
x+y
x*y
x/y
x <- c(0,2,4,-3); !x
x <- c(NA, TRUE); y <- c(FALSE, NA) #NA: Not Applicable/Available: 결측값(해당사항없음)
x & y
x | y

###### Relational Operators
# >, <, >=, <=, ==, !=
## * 결과는 TRUE, FALSE
######
x <- c(1,2,3,-1)
x > 0
x1 <- 0.1 ; x2 <- 0.1; x3 <- 0.5 - 0.4
x1 == x2
x1 == x3
identical(x1,x3)
all.equal(x1,x3)
 x <- 45; (x > 10)+(x > 20)+(x > 30)+(x > 40) 






###### 분석자료불러오기: scan
# 직접입력: c()
## * 벡터생성
x <- c(1,2,3,4)
y <- c("A","B",'C','D')
# 직접입력: scan()
## * 옵션이 없는 경우 수치형 벡터 생성
data1 <- scan()
1
2
3 4
5

## * 문자형 자료
data2 <- scan()
A B C
? scan
## * 주요 옵션: scan(file = "", what = double(0), n = -1, sep = "",
## skip = 0, nlines = 0, fileEncoding = "", ... )
## * 문자 자료인 경우 what = “” 또는 what = “character”
data2 <- scan(what="") #문자입력지정
A B C
## * 다변량 자료 입력
#### * 예제: 첫번째 숫자, 두번째 문자
data3 <- scan(what=list(0,""))
1 A
2 B
3 4 5 T
6 F
# 텍스트 파일 자료 불러오기: scan()
## * 작업 디렉토리 변경
getwd() # 현재 작업공간
dir(getwd()) # 현재 작업공간에 있는 파일목록
setwd("C:/통프") # 작업공간 변경: 경로는 '\'가 아닌 '/'로 표시
x1 <- scan("data1.txt")
str(x1)
## * 부분자료 읽기
x2 <- scan("data1.txt", n=10)
x3 <- scan("data1.txt", nlines = 10)
## 문자형 자료 읽기
gender <- scan("gender.txt","") # 파일명이 있는 경우
## * 다변량자료 파일 읽기
x4 <- scan("data2.txt", what=list("","",0))
x4 <- scan("data2.txt", what=list("","",0), skip=1) # Read 474 records
str(x4)
x5 <- scan("data3.txt", what=list("","",0), skip=1) # 저장방식이 UTF-8
x5 <- scan("data3.txt", what=list("","",0), skip=1, fileEncoding = "UTF-8")
str(x4)
