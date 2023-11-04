## Data폴더 위치로 변경
setwd("E:/통계프로그래밍/data")
setwd("E:\\통계프로그래밍\\data")
getwd()
### 파일 목록
파일이름 <- dir()
### Excel 파일 확인(xlsx만 사용)
파일개수 <- length(파일이름)
이름분해 <- strsplit(파일이름,"[[:punct:]]")
### - 이름분해: list
확장자 <- sapply(이름분해,function(x) x[length(x)])
엑셀파일 <- 파일이름[확장자 == "xlsx"]
엑셀파일 <- sort(엑셀파일)
엑셀개수 <- length(엑셀파일)
전체자료 <- NULL
for (i in 1:엑셀개수){ 
  dfrm <- xlsx::read.xlsx(엑셀파일[i],sheetIndex=1) 
  dfrm$month <- i 
  전체자료 <- rbind(전체자료,dfrm)
}
##read_excel로 읽어들이는 것으로 바꾸기
##자체적으로 주어지는 특유의 데이터프레임 형태가 있음
for (i in 1:엑셀개수){ 
  dfrm <- readxl::read_excel(엑셀파일[i],sheet="data") 
  dfrm$month <- i 
  전체자료 <- rbind(전체자료,dfrm)
}
##파일이름을 바로 사용하는 경우로 바꾸기
#또는 파일이름 전체에서 확장자 앞 두 글자를 가지고오는 방법도 있음(이름분해의 끝부분 두 글자)
  #as.numaric("")을 이용하여 숫자로 바꾼 후 월에 해당되는 값으로 사용
  #월 변수를 이용하는 방법은 중간에 건너뛰는 달이 있는 경우 사용할 수 없기 때문
  #내가 가지고있는 데이터의 형태에 따라 프로그램을 짜야함
for (i in 파일이름){ 
  dfrm <- readxl::read_excel(파일이름,sheet="data") 
  dfrm$month <- 월 #월 정보는 따로 만들어주기
  월 <- 월+1
  
  전체자료 <- rbind(전체자료,dfrm)
}

head(전체자료)
tail(전체자료)
전체자료 <- data.frame(전체자료)



##########################################
그림파일 <- substring(엑셀파일,1,nchar(엑셀파일)-5)
그림파일 <- paste(그림파일,".jpg",sep="")
for (i in 1:엑셀개수){ 
  dfrm <- xlsx::read.xlsx(엑셀파일[i],sheetIndex=1)
  
  jpeg(그림파일[i])
  
  par(mfrow=c(1,2)) 
  dfrm$Group <- as.factor(dfrm$Group)
  plot(Y~X1,col=Group,data=dfrm) 
  legend("topleft",legend=c("A","B"),pch=1,col=c(1,2)) 
  plot(Y~X2,col=Group, dfrm) 
  legend("topright",legend=c("A","B"),pch=1,col=c(1,2))
  
  dev.off()
}
##read_excel 사용하는 경우
for (i in 1:엑셀개수){
  dfrm <- readxl::read_excel(엑셀파일[i], sheet="data")
  
  jpeg(그림파일[i])
  
  par(mfrow=c(1,2)) 
  dfrm$Group <- as.factor(dfrm$Group)
  plot(Y~X1,col=Group,data=dfrm) 
  legend("topleft",legend=c("A","B"),pch=1,col=c(1,2)) 
  plot(Y~X2,col=Group, dfrm) 
  legend("topright",legend=c("A","B"),pch=1,col=c(1,2))
  
  dev.off()
}

###########################################
result <- lm(Y~X1+X2,data=dfrm)
anova(result)

getCoeff <- function(dfrm){ 
  result <- lm(Y~X1+X2,dfrm) 
  beta <- coefficients(result) 
  return(beta)
}

A그룹 <- NULL
B그룹 <- NULL
for(i in 1:엑셀개수){ 
  #dfrm <- xlsx::read.xlsx(엑셀파일[i],sheetIndex=1)
  dfrm <- readxl::read_excel(엑셀파일[i],sheet="data")
  dfrm$Group <- as.factor(dfrm$Group) 
  result <- by(dfrm, dfrm$Group, getCoeff) 
  계수리스트 <- lapply(result,function(x) x) 
  A그룹 <- rbind(A그룹,계수리스트$A)
  B그룹 <- rbind(B그룹,계수리스트$B)
}

회귀계수 = data.frame(A그룹,B그룹)
names(회귀계수) = c("절편A","beta1A","beta2A","절편B","beta1B","beta2B")

par(mfrow=c(2,1),mar=c(5,5,2,5))
plot(A그룹[,2],type="l",xlab="월",ylab="X1 회귀계수",main="A그룹 계수추이")
par(new=T)
plot(A그룹[,3],type="l",col="blue", lty=2, axes=F,xlab=NA,ylab=NA)
axis(side = 4)
mtext(side = 4, line = 3, "X2 회귀계수",col="blue")

plot(B그룹[,2],type="l",xlab="월",ylab="X1 회귀계수",main="B그룹 계수추이")
par(new=T)
plot(B그룹[,3],type="l",col="blue", lty=2, axes=F,xlab=NA,ylab=NA)
axis(side = 4)
mtext(side = 4, line = 3, "X2 회귀계수",col="blue")


###########################################
전체자료 <- NULL
A그룹 <- NULL
B그룹 <- NULL
for (i in 1:엑셀개수)
{ dfrm <- xlsx::read.xlsx(엑셀파일[i],sheetIndex=1) dfrm$month <- i ### 자료 추가
전체자료 <- rbind(전체자료,dfrm)
## 그리 그리기 & 저장
jpeg(그림파일[i]) par(mfrow=c(1,2)) plot(Y~X1,col=Group, dfrm) legend("topleft",legend=c("A","B"),pch=1,col=c(1,2)) plot(Y~X2,col=Group, dfrm) legend("topright",legend=c("A","B"),pch=1,col=c(1,2)) dev.off()
# 회귀계수 계산 & 추가
result <- by(dfrm, dfrm$Group, getCoff) 계수리스트 <- lapply(result,function(x) x) A그룹 <- rbind(A그룹,계수리스트$A)
B그룹 <- rbind(B그룹,계수리스트$B)
}