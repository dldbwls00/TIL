####################
### 리스트(list)
####################
## * 리스트 생성
## * 여러 가지 자료형(mode)의 원소를 포함
x <- c(10,20,30); y <- c("A","B","C","D")
(Vec <- c(x,y)) # 벡터와 벡터의 결합, 모두 문자로 바뀜
(List1 <- list(x,y)) # 벡터와 벡터로 이루어진 리스트
names(List1) <- c("X","Y")
List1
(List2 <- list(X=x,Y=y)) #factor X에 x 대입 -> 이름 붙이기
(List2 <- list(x1=0, x2=x, x3=y, x4=mean))

Scandata <- scan("data3.txt", what=list("","",0),skip=1,fileEncoding = "UTF-8")
Scandata
str(Scandata)
names(Scandata) <- c("gender","jobcat","salary")



## * 리스트 참조
### * 리스트는 인덱싱 가능
Scandata[[1]]
Scandata$gender
Scandata[1] # list, 변수명 포함

class(List1)
class(List1[1])
class(List1[[1]])
class(List1$X)

List1[[1]][2] # 첫번째 리스트, 두번째 원소 참조
List1[[c(1,2)]] # 첫번째 리스트, 두번째 원소 참조
List2[c(2,3)] # 2번, 3번 리스트
List2[c(2,3)][1] # 2번, 3번 리스트 중 첫번째 리스트
List2[c(2,3)][[1]] # 2번, 3번 리스트 중 첫번째 리스트의 원소들

## * mean: 벡터함수
mean(Scandata[[3]])
mean(Scandata[3])
List2[[4]](x) # List2$x4(x)


#################
## * 리스트에서 리스트(원소) 제거
List2[1] <- NULL # 제거
List2$x4 <- NULL
값 <- pnorm(-2:2)
이름 <- c("far.left","left","mid","right","far.right")
List3 <- list() # 빈 리스트만들기
List3[이름] <- 값 # 각 리스트에 원소가 한개
List3 < 0.5
List3[List3 < 0.5] <- NULL # 조건을 사용하여 리스트(원소) 제거
List4 <- list(Value=값)
List4
List4 < 0.5
unlist(List4) < 0.5


#################
## * 리스트와 리스트(벡터) 결합(추가)
Lst1 <- c(List3,List4) # 리스트와 리스트 결합
Lst1
Lst2 <- list(List3,List4)
Lst2
Lst2[1]
Lst2[[1]][1]
Lst2[[1]][[1]]
Lst2[[1]]$far.right
Lst2[[2]]$Value
summary(Lst1)
summary(Lst2)
c(List4,값)
list(List4,값)




