#############################
######## 표를 이용한 자료정리
#############################
# 도수분포표(Frequency Table)
## * 각 범주의 빈도(도수), 상대도수 표시
## * 관련함수: table, prop.table
gender <- scan("gender.txt","")
## * table() 함수
table(gender)
table(gender)[1]

gender.tbl <- table(gender)
gender.tbl["F"] #이름으로 접근 가능
sum(gender.tbl) #합
gender.tbl/sum(gender.tbl) # 비율 tbl/sum(tbl)

## * prop.table() 함수
prop.table(gender.tbl) #위의 비율 구하는 수식과 같음
#tbl/sum(tbl) 또는 prop.table(tbl)

gender.prop <- round(100*prop.table(gender.tbl),1) #소숫점아래 첫번째자리까지

freq.tbl <- cbind(gender.tbl, gender.prop) #옆으로 붙음, col-bind

colnames(freq.tbl) <- c("도수","상대도수(%)") #그냥 names도 되지만 명확하게 하기 위해
freq.tbl


#############################
#### 그래프를 이용한 자료정리
#############################
# 원도표
# 관련함수
beer <- c(3,4,1,1,3,4,3,3,1,3,2,1,2,1,2,3,1,1,1,1,4,3,1,2)
(beer.count <- table(beer))
pie(beer.count)
names(beer.count) <- c("domestic\ncan", "domestic\nbottle", "microbrew\n", "import\n")
order(beer.count) # [1]: 가장 작은 자료의 위치
pie(beer.count[order(beer.count)], col = c("beige", "blanchedalmond", "bisque1", "bisque3"))

## * 막대그래프
## * 관련함수: plot, barplot
barplot(beer.count)
barplot(beer.count, ylab="도수", xlab="맥주종류", space=0.5)
abline(h=0)
### * order(beer.count, decreasing=T): [1] 가장 큰 자료의 위치
beer.count[order(beer.count,decreasing = T)]
barplot(beer.count[order(beer.count)] , horiz = TRUE,
        las = 1, #label을 수평으로 표
        col = c("beige", "blanchedalmond", "bisque1", "bisque3"), main = "맥주판매량", xlab = "판매량")


par(oma = c(1, 2, 1, 1)) # Sets outside margins(하좌상우)
par(mar = c(4, 4, 1, 1))
barplot(beer.count[order(beer.count)], horiz = TRUE,
        las = 1, #label을 수평으로 표
        col = c("beige", "blanchedalmond", "bisque1", "bisque3"), main = "맥주판매량", xlab = "맥주판매")
abline(v=0)
