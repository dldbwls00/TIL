###############
## Matrix: 행X열 => 2차원 구조
## * 동일자료형 : mean등의 벡터함수 적용가능
###############
x <- 1:6
y <- 1:7
z <- 1:5
## * 행렬 생성(기본: 1열부터 자료 입력)
### - 행렬 크기: length, nrow, ncol, dim
m1 <- matrix(x,2,3)
length(m1)
dim(m1)
### - 입력순서 변경
m2 <- matrix(x,2,3,byrow=T)
## * 입력자료의 수와 행렬 크기가 다른 경우
m3 <- matrix(y,2,3,byrow=T)
m4 <- matrix(z,2,3,byrow=T) #Recycle
## * 자료 참조:
### - 행렬구조
### - 참조순서
m2[1,2]
m2[3]
m3[1,]
m3[,c(1,2)]
m3[1,,drop=F]
xx <- 1:4
dim(xx)
dim(xx) <- c(2,2)
t(xx) # transpose
## * 이름
colnames(xx) <- c("C1","C2")
xx[,"C1",drop=F]
## 산술연산:
### - 행렬 vs 행렬: 동일한 dim
### - 행렬 vs 벡터: 순서대로(Recycle)
m1+m2
v1 <- c(0,5)
m1*v1
m1+xx # dim이 다름
## 행렬(벡터) 결합
cbind(m1,m2) #nrow(m1) = nrow(m2)
rbind(m1,m2) #ncol(m1) = ncol(m2)
###########
## array: n-차원
###########
tbl <- with(mtcars,table(vs,am,gear))
ary <- array(tbl,c(2,2,3))
ary[1,,]
ary[,1,]
ary[1,1,]
ary[c(1,2),1,]
###############
## Time Series
###############
x <- scan("birth.txt") ## 2000.1부터 월별 출생아수
### - 산점도(scatter plot): x축 관측순서
plot(x)
birth <- ts(x,start=c(2000,1),frequency=12)
birth
### - 시계열그림: x축 시간(선으로 연결)
plot(birth)

y <- scan("marriage.txt") ## 2000.1부터 혼인건수
marriage <- ts(y,start=c(2000,1),frequency=12)
## 다변량 시계열 자료
data <- ts(cbind(x,y),start=c(2000,1),frequency=12)
head(data)
plot(data)
###
ub <- max(data)
lb <- min(data)
plot(birth,ylim=c(lb,ub),ylab="건수")
lines(marriage,col="blue")
legend(2015,55000,legend=c("출생","혼인"),lty=c(1,1),col=c(1,4))
###
ls() # 현재 작업공간(workspace) 상에 있는 데이터
rm(x) # .RData에 있는 데이터 삭제
save(data,file="temp.RData") # 유형: R workspace
rm(list=ls()) ## 모든 내용 삭제
load(file="temp.RData")
data

