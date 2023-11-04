################
## Data frame
#############
## * Table형태의 리스트
## * 행: 관측개체(rownames)
## * 열: 변수(colnames, names)
## * 데이터프레임 생성
Data1 <- read.csv("Employee.csv")
str(Data1)
head(Data1)

colnames(Data1)[1]
names(Data1)
rownames(Data1)[1:10] ## 문자


# List를 Data Frame으로
temp <- scan("data3.txt", what=list("","",0),skip=1,fileEncoding = "UTF-8")
str(temp)
Data2 <- data.frame(temp) # as.data.frame
head(Data2)
colnames(Data2) <- c("gender","jobcat","salary")
# names(Data2) <- c("gender","jobcat","salary")
names(temp) <- c("x1","x2","x3")
str(temp)
Data3 <- data.frame(temp)
head(Data3)


## Vector를 Data Frame으로
x1 <- c(rnorm(10),rnorm(10,1),rnorm(10,2))
? rnorm
### 반복자료 생성: rep
x2 <- rep(c("A","B","C"),each=10)
rep(c("A","B","C"),10)
rep(c("A","B","C"),c(10,5,15))
rep(c("A","B","C"),10,each=3)
rep(c("A","B","C"),30,60)

Data4 <- data.frame(x1,x2)
head(Data4)
Data4 <- data.frame(Y=x1,X=x2)
head(Data4)

### Data Frame에 자료 추가
nrow(Data4)
ncol(Data4)
length(Data4) #변수의 개수


x3 <- rep(c("A","B","C"),5)
x4 <- rep(c("D","E","F"),4)
length(x3); length(x4)

tempData <- data.frame(x1,x2,x3) # 30은 15의 배수
tempData
tempData <- data.frame(x1,x2,x4) # 30은 12의 배수가 아님
tempData
temp <- list(X1=x1,X2=x2,X3=x3,X4=x4)
data.frame(temp) ## 길이가 배수가 아님
tempData <- data.frame(temp[c(1,2,3)])
tempData


#########################
## * Data frame 참조
str(Data1)
head(Data1)
## * 방법1
Data1$salary
class(Data1$salary)
Data1$salary[1:10]
## * 방법2
head(Data1[5])
class(Data1[5])
## * 방법3
head(Data1[[5]])
class(Data1[[5]])

head(Data1[,5]) # 행렬형태[행, 열]
Data1[1:10,5]

head(Data1[c(5,6)])
head(Data1[,c(5,6)])

head(Data1[c("salary","salbegin")])
head(Data1[,c("salary","salbegin")])

head(Data1[[c(5,6)]]) # 5번째 변수의 6번째 자료(리스트에서도 동일하게 적용)
head(Data1[[, c(5,6)]])
########################
## * 벡터함수적용
mean(Data1$salary)
mean(Data1[[5]])
mean(Data1[,5])
mean(Data1[5]) # data frame
sd(Data1[5])
var(Data1[5])
## Data frame에 적용되는 함수
# ck <- sapply(Data1,is.numeric) # sapply: Data1의 각 변수에 대해 함수적용
#head(Data1[ck])
#numData <- Data1[ck]
#numData <- numData[-1] # 첫번째 변수 제외
numData <- Data1[-c(2,4,9)]
colMeans(numData)
rowMeans(numData)[1:10]
colSums(numData)
rowSums(numData)[1:10]
var(numData)
cov(numData)
cor(numData)
plot(numData)

