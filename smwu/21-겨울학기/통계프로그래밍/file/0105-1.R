### 저수준 그래픽:
# grid()
par(mar=c(4,4,2,2), mfrow=c(2,1))
# (1)
plot(iris$Sepal.Length,iris$Sepal.Width,pch=16,col=as.integer(iris$Species))
### plot(Sepal.Width-Sepal.Length, data=iris, pch=16,col=as.integer(iris$Species))와같음
### 이 때는 y축 먼저 씀
### 왜 오류?
grid()
# (2) 3 times 4 grid
plot(iris$Sepal.Length,iris$Sepal.Width, pch=16,col=as.integer(iris$Species))
grid(3,4,lty=2,lwd=1.2,col="blue")


# rug()
par(mar=c(4,4,2,2),mfrow=c(2,1))
# (1)
plot(density(quakes$lat)); rug(quakes$lat)
# (2)
plot(density(quakes$long),main="side=3,col='blue',ticksize=0.04")
rug(quakes$long,side=3,col="blue",ticksize=0.04)



# 화면분할
m <- matrix(c(1,1,2,3), ncol=2, byrow=T)
layout(mat=m)
plot(cars, main="scatter plot of cars data", pch=19, col=4)
hist(cars$speed); hist(cars$dist)


par(mfrow=c(1,1))
# pch, cex, text, mtext, axis 등
# type="n"옵션으로 그림을 그리지 않음.
plot(0,0,xlim=c(0,26.5),ylim=c(-0.05,34.25),xlab="",ylab="",type="n",axes=F) #빈공간만들기
# pch: Plot symbols 0:25. Overlay with numbers 0 - 25
grayscale <- gray(seq(from=0.1, by=0.05, length=13))
xpos <- seq(from=1, by=2,length=13) # x축 좌죠
ypos <- rep(23,13) # y축 좌표
ypos2 <- ypos-4 # y축 좌표
points(ypos ~ xpos, cex=3, col=grayscale, pch=0:12)
points(ypos2 ~ xpos, cex=3, col=rev(grayscale), pch=13:25)

text(ypos ~ xpos, labels=0:12, cex=0.75)
text(ypos2 ~ xpos, labels=13:25, cex=0.75)



# Enlarged and/or coloured symbols or text
xpos <- c(21.5, 23.5, 25.5); ypos <- rep(15, 3);
points(ypos~xpos, pch=0:2, cex=4:2, col=gray(c(.2,.4,.6)))
# Positioning of label with respect to a point
xpos <- c(22.5, 21.5, 22.5, 23.5); ypos <- c(6,7,9,7);
points(ypos ~ xpos, pch=16, cex=1.5, col=gray((1:4)/5))
posText <- c("below (pos=1)", "left (2)", "above (3)", "right (4)")
text(ypos~xpos, labels=posText, pos=1:4)


# Sides (margins) are numbered 1, ...4. Label them acordingly
mtext(side=4, line=0.5, text="Side 4", adj=1)
# Flush right on margin (Flush left: adj=0)
## Center labels in margins 1 to 3 
for(i in 1:3)
  mtext(side=i, line=0.5, text=paste("Side",i), adj=1)
## Label selected plotting positions
labpos <- c(0, 6:7, 9, 15, 19, 23)
for(pos in labpos)
  axis(side=4, at=pos, col="red", las=2)


## 색상표시
cols <- colors()
# 색상가지 수
length(cols)
# 색상
head(cols); tail(cols)
# 해당색상의 RGB값
col2rgb("red")
## [,1]
## red 255
## green 0
## blue 0
clr.1 <- c("#000000","#FF0000","#00FF00","#0000FF")
clr.2 <- c("#00FFFF","#FF00FF","#FFFF00","#FFFFFF")
par(mar=rep(3,4), mfrow=c(2,1))
barplot(rep(1,4), col=clr.1, axes=F,main="black, red, green, blue")
barplot(rep(1,4), col=clr.2, axes=F,main="cyan, magenta, yellow, white")
# ramp (sequence) of colors
pal.1 <- colorRampPalette(c("white","black")); clr.1 <- pal.1(7)
pal.2 <- colorRampPalette(c("red","green")); clr.2 <- pal.2(7)
par(mar=rep(3,4), mfrow=c(2,1))
barplot(rep(1, length(clr.1)), col=clr.1, axes=F, main="from white to black")
barplot(rep(1, length(clr.2)), col=clr.2, axes=F, main="from red to green")
# R 색상함수
par(mar=rep(3,4), mfrow=c(5,1))
n <- 7
barplot(rep(1,n),col=rainbow(n,alpha=1),axes=F,main="rainbow colors")
barplot(rep(1,n),col=heat.colors(n,alpha=1),axes=F,main="heat colors")
barplot(rep(1,n),col=terrain.colors(n,alpha=1),axes=F,main="terrain colors")
barplot(rep(1,n),col=topo.colors(n,alpha=1),axes=F,main="topo colors")
barplot(rep(1,n),col=cm.colors(n,alpha=1),axes=F,main="cyan-magenta colors")



par(mfrow=c(1,1))
#######################################다차원그래프
### 산점도 행렬
y <- unclass(iris$Species)
pairs(iris[,1:4],pch=c(22,25,21)[y],bg=c("red","green","blue")[y])

### dot chart
VADeaths # Death Rates in Virginia (1940)
par(mfrow=c(1,2))
dotchart(VADeaths)
title(main="Death Rates (Population group)")
dotchart(t(VADeaths), xlim=c(0, 100))
title(main="Death Rates (Age group)")

# HairEyeColor: Hair and Eye Color of Statistics Students
tbl <- margin.table(HairEyeColor,c(1,2))
## 독립성 검정결과(독립성 가정)
assocplot(tbl)
chisq.test(tbl)





install.packages("vcd")
library(vcd)
# Titanic: Survival of passengers on the Titanic
# 1. Sex(성별)에 따른 생존율
vcd::doubledecker(Survived ~ Sex, data=Titanic,gp=gpar(fill=c("grey90","red")))
# 2. Class(승선유형, 1st/2nd/3rd/Crew)에 따른 생존율
vcd::doubledecker(Survived ~ Class, data=Titanic,gp=gpar(fill=c("grey90","red")))
# 3. Sex/Class에 따른 생존율
vcd::doubledecker(Survived ~ Sex + Class, data=Titanic,gp=gpar(fill=c("grey90","red")))





################
## ggplot2
install.packages("ggplot2")
library(ggplot2)
data(mpg)
str(mpg)

ggplot(data=mpg, aes(x=displ, y=hwy))
ggplot(data=mpg, aes(x=displ, y=hwy)) + geom_point()
ggplot(data=mpg, aes(x=displ, y=hwy)) +
  geom_point()

p=ggplot(data=mpg, aes(x=displ, y=hwy))
p + geom_point()

ggplot(data=mpg, aes(x=displ, y=hwy, colour=class)) + geom_point()
g <- ggplot(data=mpg) +
  geom_point(mapping= aes(x=displ, y=hwy, color=class))
g

g + facet_wrap(~ class, nrow=2)
g + facet_grid(~ class) 
##################
### Lattice
ls(pos=grep("lattice", search()), pattern="^panel.")
## xyplot
# Simple scatterplot
library(lattice)
xyplot(Ozone~Wind, data=airquality)
xyplot(Ozone~Wind | Month, data=airquality)
# bwplot()
bwplot(voice.part~height, data=singer)
# densityplot()
densityplot(~height | voice.part, data=singer, layout=c(2,4), bw=5)
# dotplot()
dotplot(variety ~ yield | site, data=barley,groups=year,layout=c(2,3), key=simpleKey(levels(barley$year),space="bottom",columns=2))
# histogram()
do.breaks(c(59.5,76.5),7) # diff(do.breaks(c(59.5,76.5),7))
## [1] 59.50000 61.92857 64.35714 66.78571 69.21429 71.64286 74.07143 76.50000
histogram(~height| voice.part, data=singer,breaks=do.breaks(c(59.5,76.5),7))
histogram(~height | voice.part, data=singer, type="density", panel=function(x,...){ panel.histogram(x,...) panel.mathdensity(dmath=dnorm,col="blue",args=list(mean=mean(x),sd=sd(x))) })
# paralletlplot()
parallelplot(~ iris[,1:4] | Species, data=iris)
#install.packages(c("vcd","ggplot2","ggthemes","gridExtra","plyr",
# "dplyr","tidyr","GGally","ggmap","lubridate","corrplot"))
# histogram
library(ggplot2)
ggplot(iris, aes(Petal.Length)) + geom_histogram()
# 산점도
library(ggthemes)
ggplot(iris, aes(Petal.Length, Petal.Width,color=Species))+geom_point()+theme(legend.position="bottom")
library(dplyr)
data(Pima.tr2, package="MASS") # Pima Indians diabetes data set
str(Pima.tr2) # 자료 요약
# 그림저장
h1 <- ggplot(Pima.tr2,aes(glu))+geom_histogram()
h2 <- ggplot(Pima.tr2,aes(bp))+geom_histogram()
h3 <- ggplot(Pima.tr2,aes(skin))+geom_histogram()
h4 <- ggplot(Pima.tr2,aes(bmi))+geom_histogram()
h5 <- ggplot(Pima.tr2,aes(ped))+geom_histogram()
h6 <- ggplot(Pima.tr2,aes(age))+geom_histogram()
library(gridExtra) # grid 상에 ggplot2 그래픽을 배열해주는 패키지
grid.arrange(h1,h2,h3,h4,h5,h6,nrow=2)
library(dplyr) # 데이터프레임 객체에 대한 자료 처리 패키지
spima <- dplyr::select(MASS::Pima.tr2, 2:7) # 2:7 => glu:age
boxplot(scale(spima),outcol="red",pch=24) # 표준화 후 boxplot/outlier 자료 "red"로 표시
# 상관분석과 산점도
library(GGally)
GGally::ggpairs(spima,diag=list(continuous="density"),axisLabels="show")