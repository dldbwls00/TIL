#########
## factor
##########
## * 범주형변수의 특별한 형태
## * Level(수준)이라는 특별한 속성을 가짐
## * 그룹을 나타내는 변수의 경우 factor로 설정하면 유용
###############
## factor의 생성
### * 수치자료의 범주화: 예: 도수분포표
x <- rnorm(30)
bd <- -3:3
범주화 <- cut(x,breaks=bd)
class(범주화)

### * 데이터프레임 생성
Data1 <- read.csv("Employee.csv") # default: 문자열은 factor(3.X이전), character(4.X이후)
str(Data1)
Data1$gender[1:10]
Data2 <- read.csv("Employee.csv",stringsAsFactors = T)
str(Data2)
Data2$gender[1:10]
### * factor 생성함수
x <- gl(4,3)
levels(x) <- c("A","B","C","D")
### * factor 변환함수
x <- rep(c("A","B","C","D"),5)
x1 <- as.factor(x)
y <- rep(1:4,5)
y1 <- as.factor(y)
is.factor(y); is.factor(y1) # factor인지 확인



####################
## * factor의 자료형
class(Data2$gender)
mode(Data2$gender) # 수치형
typeof(Data2$gender) # 정수형: level의 값
xx <- c(x1,y1)

#############################
## * factor 참조와 Level 제거
### * 범주형이기 때문에 같다, 다르다만 비교 가능
x1[1:5]
x1 == "A"
y1 == "1"
x1 == A
y1 == 1
Data1$gender[1:10] < "여성" # 문자
Data2$gender[1:10] < "여성" # factor

######
x3 <- x1[x1 != "D"] #Levels 확인
y3 <- y1[y1 != 4] # y3 <- y1[y1 != "4"]
x3[,drop=T] # Level 제거
y3[,drop=T]
x4 <- factor(x,levels=c("A","B","C"))
y4 <- factor(y,levels=1:3)
x4[!is.na(x4)]
y4[!is.na(y4)]


#########
## * factor의 활용
temp1 <- Data1[Data1$jobcat != "사무직",]
temp2 <- Data2[Data2$jobcat != "사무직",]
temp1$jobcat
temp2$jobcat
table(temp1$jobcat)
table(temp2$jobcat)



boxplot(Data1$salary)
boxplot(Data1$salary~Data1$jobcat)
boxplot(salary~jobcat,data=Data1)
boxplot(salary~jobcat,data=Data2)
boxplot(salary~jobcat,data=temp1)
boxplot(salary~jobcat,data=temp2)


## factor를 벡터
as.character(x1)
as.character(y1)
as.numeric(y1)
as.numeric(x1) # factor는 정수형
