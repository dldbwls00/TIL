###
# 벡터(vector)
## * 자료의 최소단위
## * [ ]로 인덱싱: 1부터 시작
setwd("E:/통계프로그래밍")
testdata <- scan("data1.txt")
head(testdata,10) #default 6개
tail(testdata)
testdata[1] #첫번째 데이터
testdata[c(2,3,5)] #2,3,5번째 데이터

## * 모든 원소들이 같은 자료형(mode)을 가짐
x <- c(1,2,3)
y <- c(1,2,3,"1") #하나가 문자면 모두 문자로 바뀜


# 벡터 생성 : 연산자
## * n:m 형태로 표시
### - n<m이면 n, n+1, ..., [m]을 n>m이면 n, n-1, ..., (m)
1:10 #1, 2, 3, ..., 10
10:1 #10, 9, 8, ... 1
#뒤에서 캐릭터를 숫자로, 숫자를 캐릭터로 바꾸는 함수 배움

test <- testdata[1:5]
test #testdata의 1~5번째 데이터
## * 벡터에 데이터 추가, 삽입, 제거하기
(test <- c(0,test,0)) #덩어리로 들어갈 수 있음
test[1] <- 99
test[10] <- 7
test #정의되지 않은 인덱스는 NA로 들어감
x <- c(5,6)
test <- append(test, x, after=5)#5 뒤에 넣음
test

test[-c(10,11)] #또는 test[c(-10,-11)]
#10,11번째 인덱스를 뺀 값을 출력함. 실제로 값이 빠지진 않음
test

# testdata에서 값이 30000이상인 자료만 선택
testdata >= 30000 #전체 데이터에 대해 t, f로 출력함: recycling처럼 각각 비교
id <- which(testdata >= 30000) #true인 것의 인덱스가 담김
id
testdata[-id]
testdata[!(testdata >= 30000)]
testdata[which(testdata >= 30000)]
testdata[!which(testdata >= 30000)] #결과가 numeric(0)??

## * 결측값: NA
(test <- c(NA, testdata[1:5]))
is.na(test) # 결측값 확인
#test[1] == NA 는 틀린 코드. 값을 알 수 없으므로 NA라는 결과가 나온다

결측값 <- c("NA"," ", "", NA) #""안에 쓴 NA는 문자처리
is.na(결측값)
test[!is.na(test)] #NA가 아닌 데이터만 가져와라

## * 원소에 이름을 부여할 수 있음
test <- testdata[1:4]
names(test) <- c("X1","X2","X3") #이름이 붙지 않은 네 번째 원소는 <NA>라고 이름이 붙음
test
test[c("X1","X3")] #인덱스 대신 이름 사용 가능


################################################
#### 통계함수
# 벡터함수
## * mean: 평균
## * median: 중앙값
## * min: 최솟값
## * max: 최댓값
## * sd: 표준편차
## * quantile: 분위수
## * fivenum: Tukey's five number summaries
# 벡터분석 가능함수
## * length: 벡터의 길이=표본크기(결측값 없는 경우)
## * sum: 합
## * var: 분산
## * summary: 주요통계
# 평균
mean(testdata) #평균
sd(testdata) #표준편차
quantile(testdata,c(0.25,0.5,0.75))  #사분위수
summary(testdata) #주요통계 요약
length(testdata) #벡터의 길이(표본의 크기, 결측값 포함)
sqrt(var(testdata)) #표준편차

testNA <- testdata
testNA[1:10] <- c(NA,10000) # 결측값
mean(testNA)
mean(testNA[!is.na(testNA)]) #결측값을 제거한 평균, 데이터에서 실제로 사라지지는 않음
mean(testNA,na.rm=T) #결측값 제거

summary(testNA) #자동적으로 결측값이 빠지고 결측값이 몇 개인지 알려줌. 적절히 반올림

length(testdata) #표본크기가 아닌 데이터의 길이. 결측값을 포함함
length(testNA) #표본크기가 아닌 데이터의 길이. 결측값을 포함함
!is.na(testNA) #tf로 나타남
sum(!is.na(testNA)) #결측값이 아닌 것의 개수 -> 표본크기

testdata >= 30000 # 30000이상인 자료만 선택
sum(testdata >= 30000)
sum(testNA >= 30000) #na
sum(testNA >= 30000,na.rm=T) #na를 뺀 나머지 데이터에서 3000 이상인 것

### 결측값이 있는 경우 30000이상의 비율
sum(testNA >= 30000,na.rm=T)/sum(!is.na(testNA))

which(testNA >= 30000) #30000이상인 것의 인덱스

test3 <- testdata[which(testdata >= 30000)] #testdata에서 30000이상인 데이터를 test3에 대입
min(test3)
test4 <- testdata[testdata >= 30000] #test3의 데이터와 같다. 같은 표현
min(test4)

# 벡터 생성 연산자와 함수
## * : 연산자 : n:m 형태로 표시
### - n<m이면 n, n+1, ..., [m]을 n>m이면 n, n-1, ..., (m)
### - n과 m에 값에 따라 [m]과 (n)의 값은 달라짐
## * seq 함수: sequence 생성
### - seq(from=n, to=m, by=k)
### - seq(from=n, to=m, length=k), length 대신 length.out도 가능
## * rep : 반복자료 생성
### - rep(x, times=n, length.out=NA, each=m)