###########
## 조건문: if문
## * if (condition) {statements1} else {statements2}
## * else {statements2}는 생략가능하며 statements가 하나인 경우 {} 생략가능
## * condition의 결과가 벡터이면 첫 번째 원소만 적용
## 조건이 여러개인 경우
## * if (condition1) {
## } else if (condition2) {
## } else {}
## 벡터 조건문:
## * ifelse(condition, statement1, statement2)
## * condition의 결과가 벡터이면 개별 결과 적용
## * 복습: 논리연산
x <- c(F,T); y <- T
x && y; x || y
x & y; x | y
x <- 1
if (x > 0) y <- "Yes" else y <- "No"
y
# 주의
if (x > 0) y <- "Yes"
else y <- "No"
y
x <- -1:1
if (x > 0) y <- x+1 else y <- x-1
y
z <- ifelse(x > 0, x+1, x-1)
z
ifelse(x %% 2 == 1, "odd", "even")
홀짝 <- ifelse(x %% 2, "odd", "even")
홀짝
##############
## 반복문
## for 루프
## * for (name in vector) statement1
## * for (name in vector) {statements1}
## * vector는 문자도 가능
## while 루프
## * while(condition) statement
## * while(condition) {statements}
## * condition이 참이면 statement(s)를 실행
## * 무한 루프에 빠질 가능성이 있음
## repeat 루프
## * repeat{statements}
## break로 중단
## * 무한 루프에 빠질 가능성
# 1~10까지 합
n <- 10
csum <- 0
for (x in 1:n) csum <- csum+x
csum
# 1~n까지 짝수의 합
n <- 1000000
x <- 1:n
evensum <- 0
for (value in x) if (value %% 2 == 0) evensum <- evensum+value
evensum
## 반복문은 속도가 느림
sum(x[x%%2 == 0])
sum(x[!x%%2])
## 문자처리 가능
item = c("C","B","D","A","F")
for (x in c("A","B"))
  cat(x, " is ",which(x==item),"-th item.\n")
for (x in c("A","B","K"))
  cat(x, " is ",which(x==item),"-th item.\n")
for (x in c("A","B","K"))
  if (x %in% item) ## %in% :vector 비교 가능(문자, 숫자 비교가능) cat(x, " is ",which(x==item),"-th item.\n") ## 반복횟수가 정해지지 않은 경우: while, repeat
    ## while(조건): 조건이 참이면 계속수행
    ## repeat: 최소한 한번은 수행
    # -1.0보다 작은 값이 나올때까지 표준정규난수를 발생
    x <- numeric() # x <- NULL
for (i in 1:1000) #충분히 큰 수만큼 반복
{ 난수 <- rnorm(1) x <- c(x,난수) if (난수 < -1.0) break
}
x
난수 <- rnorm(1)
x <- 난수
while(난수 >= -1.0)
{ 난수 <- rnorm(1) x <- c(x,난수)
}
x
x <- numeric()
set.seed(1)
repeat
  { 난수 <- rnorm(1)
  x <- c(x,난수) 
  if (난수 < -1.0)
    break
}
x