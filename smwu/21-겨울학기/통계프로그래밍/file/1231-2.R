##############
### 함수만들기
##############
x <- rnorm(30) # 정규난수
mean(x) # 평균계산
x
x[21] <- NA # 결측값 추가
mean(x)
mean(x,na.rm=T) # 결측값 제거 후 평균계산
mean(x,trim=0.5,na.rm=T) # 50%절사평균
median(x,na.rm=T) # 중앙값
## * 기하평균
x <- exp(rnorm(30))
exp(mean(log(x)))
## *함수만들기:
### * "함수이름 <- function(인수들)" 형태로 정의
### * 인수, default 지정
### * 인수의 조건 만족여부 확인
### - 기하평균: 자료는 0보다 커야함
minus1 <- function(x) x <- x-1 # 함수의 인수는 내부에서만 적용(지역변수)
x <- 1:5
minus5 <- function(y) x-y # 함수의 인수가 아닌 변수는 앞에서 정의된 값 적용
minus5(5)
minusA <- function(y) aa+y # 변수 a는 앞에서 정의되지 않음
minusA(5)
geomean <- function(x) exp(mean(log(x)))
geomean(x)
x <- exp(rnorm(20))
x[21] <- NA
geomean(x)
geomean <- function(x){
  x <- x[!is.na(x)]
if (min(x) >= 0.0)
  return(c(length(x),exp(mean(log(x)))))
else
  cat("자료 중 0보다 작은 값이 있어 기하평균을 계산할 수 없습니다.")
}
geomean <- function(x){ 
  x <- x[!is.na(x)]
  if (min(x) >= 0.0) { 
    Result <- list()
    Result$n <- length(x) 
    Result$Geomean <- exp(mean(log(x))) 
    Result 
  } 
  else
    cat("자료 중 0보다 작은 값이 있어 기하평균을 계산할 수 없습니다.")
}
geomean.test <- function(x,mu=1.0,alternative="two.sided",conf.level=0.95){ 
  if (mu <= 0.0 | min(x,na.rm=T) <= 0.0) 
    cat("모수설정이 잘못되거나 자료에 0보다 작거나 같은 값이 있습니다.")
  else { 
    n <- sum(!is.na(x)) 
    if (n < length(x)) 
      x <- x[!is.na(x)] 
    logx <- log(x) 
    logmu <- log(mu) 
    result <- t.test(logx,mu=logmu,alternative=alternative,conf.level=conf.level) 
    result$null.value <- exp(result$null.value) 
    result$conf.int <- exp(result$conf.int) 
    result$estimate <- exp(result$estimate) 
    return(result) 
    }
}