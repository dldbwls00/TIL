##############
## 데이터프레임
##############
## 데이터프레임생성
## * read.table(), read.csv(), xlsx::read.xlsx(), readxl::read_excel(), ... ## * data.frame(), as.data.frame()
## 데이터프레임 일부제거
## * 변수제거: dfrm$X1 <- NULL, dfrm[[1]] <- NULL, dfrm[,1] <- NULL
## dfrm[1] <- NULL, dfrm["X1"] <- NULL, dfrm[,"X1"] <- NULL
## dfrm[,-1], dfrm[-1]
## * 관측개체제거:
## dfrm[xxx,] ### xxx: 논리연산 값이 F이거나 음수
## dfrm[xx,] <- NULL 사용하지 못함
########################
## 데이터프레임 일부선택
## * 논리연산, subset()
## * 변수(열) 선택:
#### - x[, p] : 벡터 출력
#### - x[p] : 데이터 프레임 출력
#### - x[, c(p,q)] = x[c(p,q)] : 데이터 프레임
#### - p, q 대신 name 사용가능
Empy <- read.csv("Employee.csv")
head(Empy)
test <- Empy[c(2,4,5)]
head(test)
test2 <- Empy[c('gender','jobcat')]
head(test2)
## * 관측값(행) 선택
#### - x[XXX, ] : XXX가 논리연산인 경우 T, 숫자인 경우 해당 위치의 자료, #### rownames(character) 이용할 수 있음
## 짝수번째 자료
ck <- seq(1,nrow(Empy),by=2)
test <- Empy[ck,]
head(test)
## salary가 50000이상인 자료
test <- Empy[Empy$salary >= 50000,]
head(test)
## salary가 5만이상이고 jobtime이 90미만인 자료
test <- with(Empy, Empy[salary >= 50000 & jobtime < 90,])
head(test)
## * 함수를 이용하는 방법
#### - 변수선택: subset(dfrm, select=c(X1,X2))
test <- subset(Empy,select=c(5,4,2))
head(test)
#### - 관측개체선택: subset(x, subset=(X1 > 0 & X2 > 0))
test <- subset(Empy,subset=(salary > 5000 & jobtime < 90))
head(test)
test <- subset(Empy,subset=ck) # subset은 논리값만 적용
####################
## 데이터프레임 추가 및 병합
## * cbind(), rbind(), merge()
## * 변수추가
### - x$new <- y ## nrow(x)가 length(y)의 배수가 되어야 함
Empy$LogSal <- log(Empy$salary)
head(Empy)
## * 좌우결합: cbind()
#### - new <- cbind(x, y) # nrow(x) = nrow(y) # 동일한 변수명을 가질 수 있음
# data.frame을 적용하면 동일한 변수명이 있는 경우 “.숫자”가 추가
Data1 <- Empy[c(1,2,3)]
Data2 <- Empy[c(4,5)]
names(Data2)[1] <- c("educ")
Data <- cbind(Data1,Data2)
str(Data)
Data <- data.frame(Data)
str(Data)
## * 상하결합: rbind()
#### - new <- rbind(x, y) # ncol(x) = ncol(y) ## * 순서와 관계 없이 동일한 변수명을 가져야 함
Data1 <- Empy[1:100, c(1,2,3)]
Data2 <- Empy[400:nrow(Empy),c(3,2,1)]
head(Data1)
head(Data2)
Data <- rbind(Data1,Data2)
head(Data)
Data <- rbind(Data2,Data1)
head(Data)
## * key에 따른 자료병합:merge
#### - 각 데이터프레임에서 변수명이 다른 경우: by.x, by.y
#### - key가 여러개 by=c("key1","key2")
#### - merge(x, y, by = intersect(names(x), names(y)), sort = TRUE,
#### by.x = by, by.y = by, all = FALSE, all.x = all, all.y = all, ...)
Data1 <- Empy[1:20,c(1,2,3)]
Data2 <- Empy[10:35,c(1,4,5,6)]
head(Data2)
order(Data2$salary)
Data2 <- Data2[order(Data2$salary),]
head(Data2)
merge(Data1,Data2,by="id")
merge(Data1,Data2,by="id",all.x=T)
merge(Data1,Data2,by="id",all.y=T)
Data <- merge(Data1,Data2,by="id",all=T)
names(Data2)[1] <- "id2"
merge(Data1,Data2,by.x="id",by.y="id2")
## 데이터프레임 저장
## * write.table(), write.csv(), xlsx::write.xlsx(),
## install.packages("writexl"); writexl::write_xlsx()
write.table(Data,"Partial.csv",sep=",",row.names=F)

