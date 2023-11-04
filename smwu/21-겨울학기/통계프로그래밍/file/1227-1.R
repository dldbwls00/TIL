#############################
######## 표를 이용한 자료정리
#############################
# 도수분포표(Frequency Table)
## * 수치자료의 범주화
## * 범주화된 수치자료에 대해 도수분포표
## * 누적상대도수
## * 기본함수: cut, table, prop.table
## * table() 함수

salary <- scan("data1.txt")
summary(salary) #뒤에서 설명, factor는 group의 특성을 가짐

group <- c(10000,20000,30000,50000,75000,100000,150000)
# cut(salary,breaks=c(10000,20000,30000,50000,75000,100000,150000),right=F)
## default로는 범위가 (]로 잘림. right=T 설정시 범위가 [)로 잘림.
## 경계점의 데이터는 제외됨 -> 그 데이터가 최소/최대였을 경우 잘릴 수 있음
## 이 경우 include.lowest=T 사용시 포함가능 -> 첫 구간이 (]가 아니라 []로 변경됨
(salary.group <- cut(salary,breaks=group))
class(salary.group)

(salary.tbl <- table(salary.group))
names(salary.tbl) <- c("G1","G2","G3","G4","G5","G6")
salary.tbl
salary.group <- cut(salary,breaks=group,labels=c("G1","G2","G3","G4","G5","G6"))
salary.tbl <- table(salary.group)
salary.prop <- prop.table(salary.tbl)
salary.csum <- cumsum(salary.prop)
salary.freq <- cbind(salary.tbl,round(100*salary.prop,1),round(100*salary.csum,1))
colnames(salary.freq) <- c("도수","상대도수(%)","누적상대도수(%)")
salary.freq


#############################
#### 그래프를 이용한 자료정리
#############################
## * 히스토그램
hist(salary)
hist(salary, nclass=30) #y축이 frequency
hist(salary, nclass=30, probability=T) #y축이 density
## * 구간직접 지정: 1만,2만,3만,5만,7.5만,10만, 15만
### * y축: 도수 => 밀도 (전체면적=1)
hist(salary,breaks=c(10000,20000,30000,50000,75000,100000,150000)) 
hist(salary,breaks=c(10000,20000,30000,50000,75000,100000,150000), xlab="임금",ylab="밀도",main="임금히스토그램",las=1)

## * boxplot(상자그림)
boxplot(salary)
boxplot(salary,horizontal=T,xlab="임금")
abline(v=mean(salary))
### * 로그변환자료에 대한 상자그림
boxplot(log(salary,10),horizontal=T)
abline(v=mean(log(salary,10)), col="blue")
clear()
