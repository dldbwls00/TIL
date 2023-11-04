##############
## apply계열 함수
##############
Empy <- read.csv("Employee.csv")
head(Empy)
test <- Empy[c(3,5:8)]
head(test)
## 각 변수별 평균, 각 개체별 합
colMeans(test)
rowSums(test)[1:10]
# 각 변수별 중앙값, 각 개체별 중앙값(?)
mid <- NULL
n <- length(test)
for (i in 1:n) mid <- c(mid,median(test[i,]))
mid

mid <- NULL
n <- nrow(test)
for (i in 1:n) 
  mid <- c(mid,median(test[[i]])) # test[i,] : 데이터프레임 => as.numeric(test[i,])
mid
## * 모든 행(열)에 함수 적용하기
### * apply()
#### - 첫 번째 인자는 행렬(데이터프레임), 세 번째 인자는 함수
#### - 두 번째 인자: 1 ⇒ 행, 2 ⇒ 열
apply(test,2,median)
apply(test,1,median)[1:10]
# 결측값
test[1,] <- NA
apply(test,2,median,na.rm=T)
apply(test,2,range,na.rm=T)
# 범위: 최댓값 - 최소값
apply(test,2,function(x) {max(x,na.rm=T)-min(x,na.rm=T)})
range1 <- function(x) max(x,na.rm=T)-min(x,na.rm=T)
apply(test,2,range1)
## * 리스트(데이터 프레임)의 각 원소에 함수 적용하기
### * lapply(), sapply(), vapply()
#### - lapply는 결과를 리스트로 반환 =>구조화된 객체를 반환할 때 사용
#### - sapply는 결과를 벡터(행렬)로 반환
#### - vapply는 sapply와 유사하며 출력형태를 지정할 수 있음
#### - 첫 번째 인자는 리스트(데이터프레임), 두 번째 인자는 함수
## 데이터프레임에서 수치자료
#### - is.numeric()
apply(Empy,2,is.numeric) ### 모든 변수의 타입을 동일한 것으로 처리
apply(test,2,is.numeric)
check <- lapply(Empy,is.numeric)
check <- sapply(Empy,is.numeric)
test <- Empy[sapply(Empy,is.numeric)]
## t.test() : 결과는 리스트
apply(test,2,t.test)
lapply(test,t.test)
result <- sapply(test,t.test) # 문자와 숫자로 출력 : 행렬 ???
resultL <- lapply(test,t.test)
resultS <- sapply(test,t.test)
resultL[[2]] # resultL$educ
summary(resultL[[2]])
resultL[[2]]$conf.int
resultS[4,]
sapply(resultL,function(x) x$conf.int)
sapply(resultS[4,],function(x) c(x[1],x[2]))
# 한줄로 만들기
sapply(lapply(Empy[sapply(Empy,is.numeric)],t.test),function(x) x$conf.int)
CIfromDF <- function(dfrm) sapply(lapply(dfrm[sapply(dfrm,is.numeric)],t.test),function(x) x$conf.int)
CIfromDF(Empy)
##############
## apply계열 함수
##############
## * 그룹별 함수 적용
### 적용대상: 벡터 vs 데이터프레임
## * tapply()
#### - (벡터, 그룹변수, 함수, (함수옵션))
Empy <- read.csv("Employee.csv")
head(Empy)


#tapply를 모르는 경우
결과 <- NULL
성별 <- unique(Empy$gender)
for (group in 성별){
  data <- Empy[Empy$gender == group, "salary"]
  결과 <- c(결과, mean(data, na.rm=T))
}


tapply(Empy$salary,Empy$gender,mean,na.rm=T)
#또는
with(Empy, tapply(salary,gender,mean,na.rm=T))

Result <- tapply(Empy$salary,Empy$gender,t.test)
#또는
Result <- with(Empy, tapply(salary,gender,t.test))

sapply(Result,function(x) x$conf.int)
sapply(Result,function(x) c(x$conf.int[1],x$estimate,x$conf.int[2]))

#깔끔하게 정리
최종결과 <- sapply(Result,function(x) c(x$conf.int[1],x$estimate,x$conf.int[2]))
rownames(최종결과) <- c("하한", "평균", "상한")
최종결과

# 분류변수가 2개 이상인 경우
with(Empy, tapply(salary,list(gender,minority),mean))
table2 <- with(Empy, tapply(salary,list(gender,minority),range))
class(table2) # matrix
class(table2[1,1]) # list
sapply(table2,function(x) c(x[1],x[2]))
lapply(table2,function(x) c(x[1],x[2]))
## * aggregate()
#### - (데이터프레임, 그룹리스트, 함수)
aggregate(Empy[-c(2,4,9)],Empy[4],mean)

aggregate(Empy[-c(2,4,9)],Empy[c(4,9)],mean)
#### - (formula,데이터프레임,함수)
aggregate(educ+jobtime~jobcat,Empy,mean)
## * by()
#### - (데이터프레임, 그룹변수, 함수, (함수옵션))
## * 문제: jobcat에 따라 각 변수에 대한 요약(summary)
Empy$gender <- as.factor(Empy$gender)
summary(Empy)
result <- aggregate(Empy[-4],Empy[4],summary) ### 출력: 데이터프레임
aggregate(Empy[-c(2,4,9)],Empy[4],t.test)

by(Empy[-4],Empy$jobcat,summary)
by(Empy[-c(2,4,9)],Empy$jobcat,t.test) ## ????
##
## Empy[-c(2,4,9)] 자리에 벡터를 넣어야되는데 data frame이 들어옴
## 원래 data frame을 이용할 때는 ~ 사용
## 들어온 데이터와 필요한 data form이 불일치
## 값별로 t-test를 하고싶은 경우
dtfrmT <- funtion(dfrm){
  lapply(dfrm, t.test)
}

## * 문제: 각 성별에서 minority여부에 따라 salary 평균에 차이가 있는지 확인
#### - t.test(salary~minority,data=Empy) => 함수식이 들어감
#### by(Empy,Empy$gender,t.test(???))
by(Empy,Empy$gender,function(dfrm) t.test(salary~minority,var.eq=T,data=dfrm))
Result <- by(Empy,Empy$gender,function(dfrm) t.test(salary~minority,var.eq=T,data=dfrm))
sapply(Result,function(x) c(x$statistic,x$p.value,x$conf.int))