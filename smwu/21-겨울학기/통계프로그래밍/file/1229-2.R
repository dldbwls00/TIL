############
## t-test
############
## * 두 정규모집단에서의 평균 비교: independent t-test
### * 등분산성 만족여부 확인, 정규성(이상점유무) 확인
## * 쌍을 이루 자료의 평균비교(정규가정): paired t-test
## 자료의 구조
## * 1: 데이터프레임: 비교변수와 그룹변수
## * 2: 별도의 벡터로 구성
## Emplyee 자료에서 남녀간 로그초봉비교
Empy <- read.csv("Employee.csv", stringsAsFactors = T)
head(Empy)
Empy$LogBegin <- log(Empy$salbegin)
boxplot(LogBegin~gender,ylab="성별",xlab="로그초봉", horizontal = T, data=Empy)


## t-test: t.test()
t.test(LogBegin~gender,data=Empy) # unequal variances
t.test(LogBegin~gender,var.eq=T,data=Empy) # equal variances
var.test(LogBegin~gender,data=Empy) # 등분산성 검정

female <- Empy$LogBegin[Empy$gender=="여성"]
male <- Empy$LogBegin[Empy$gender=="남성"]
boxplot(female,male)
boxplot(female,male,names=c("여성","남성"),horizontal=T)
t.test(male,female)
t.test(male,female, var.eq=T)
var.test(male,female)


Empy$LogSal <- log(Empy$salary)
boxplot(LogBegin,LogSal,data=Empy) # 실행안됨: ~로 표시된 것만 가능
t.test(LogBegin,LogSal,data=Empy) # 실행안됨: ~로 표시된 것만 가능
with(Empy,boxplot(LogBegin,LogSal,names=c("로그초봉","로그연봉")))
with(Empy,t.test(LogBegin,LogSal,data=Empy))
result <- with(Empy,t.test(LogSal,LogBegin,paired=T))
result$estimate
#exp(result$estimate)
#exp(result$conf.int)