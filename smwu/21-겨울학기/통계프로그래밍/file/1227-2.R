###### 분석자료불러오기: read.table
# Table 형태의 파일자료 불러오기
## * data2.txt, data3.txt
# 작업공간 변경: 경로는 '\'가 아닌 '/'로 표시

# 빈칸 또는 탭(\t)으로 자료의 구분한 경우
test1 <- read.table("data2.txt") # 첫번째 줄(행)은 변수명
str(test1) # 변수명을 자료로 읽음
head(test1)
test1 <- read.table("data2.txt", header=T) # 첫번째 줄(행)은 변수명
str(test1)
head(test1)

names(test1)
colnames(test1)
rownames(test1)
## * 변수명 변경
names(test1)[1] <- "성별"
head(test1)

## * 저장방식이 ANSI가 아닌 경우(한글이 있는 경우)
test2 <- read.table("data3.txt", header=T) # 저장방식: UTF-8
test2 <- read.table("data3.txt", header=T, fileEncoding = "utf-8") # 저장방식: UTF-8
head(test2)


# 콤마(,) 또는 다른 기호로 자료의 구분를 구분한 경우
# csv: comma separated values
Employee <- read.table("Employee.csv", header=T) # 빈칸없이 ,로 구분
head(Employee)
Employee <- read.table("Employee.csv", header=T, sep=",")
head(Employee)
Employee <- read.csv("Employee.csv", header=T)
head(Employee)
Employee <- read.csv("Employee.csv")
head(Employee)

# 고정너비자료: 각 변수의 값이 특정위치(열)에 고정
PIN <- read.table("주민번호.txt")
PIN
PIN <- read.table("주민번호.txt",sep="-",na.string=".")
PIN

## * fwf: Fixed Width Format Files
PIN <- read.fwf("주민번호.txt", widths=c(2,2,2,-1,1,3,2,1))
PIN
names(PIN) <- c("연도","월","일","성별","신고지","순번","확인")
PINname <- c("연도","월","일","성별","신고지","순번","확인")
mean(Employee$prevexp)
PIN <- read.fwf("주민번호.txt", widths=c(2,2,2,-1,1,3,2,1),col.names = PINname)


##### 추가
str(Employee)
Employee$gender
class(Employee$gender)
table(Employee$gender)
str(Employee)
table(Employee$jobcat)
Employee$prevexp
class(Employee$prevexp)
mean(Employee$prevexp)
head(Employee)
Employee[1,]
class(Employee[1,])
Employee[c(1,2),]
Employee[c(1,3),]
Employee[1:10,]
Employee[,1]
Employee[,2]
Employee[[2]]
class(Employee[[2]])
Employee[,3]
Employee[,c(3,4)]
class(Employee[,c(3,4)])
temp <- Employee[,c(5,6)]
head(temp)
mean(temp)
sum(temp)
summary(temp)
summary(Employee)
Employee <- read.csv("Employee.csv",stringsAsFactors = T)
head(Employee)
summary(Employee)