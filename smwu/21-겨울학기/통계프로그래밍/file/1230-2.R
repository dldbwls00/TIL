##############
## 문자열처리
##############
## * 문자열 자료
Dream <- scan("I have a dream.txt",what="",encoding="UTF-8")
Dreams <- readLines("I have a dream.txt",encoding="UTF-8") # \n이 나올때 까지
Email <- readLines("email.txt")
## 주요 작업
## * 문자열 분해(분할)
## * 문자열 결합
## * 문자열 대체(변환)
#### - 소문자 -> 대문자, 대문자 -> 소문자
## * 문자열 추출
## Dream에서 5글자로 이루어진 단어
#### - nchar: 개별문자열 길이함수
Dream5 <- Dream[nchar(Dream) == 5]
Dream5 <- unique(Dream5) # 숫자도 가능
## 변환
## * sub: 첫 번째 하위문자 대체
## * gsub: 모든 하위문자 대체
Dream5[34]
test <- sub("'s","",Dream5)
gsub("p","k",Dream5)
gsub(".","",Dream5)
## * Regular Expression Syntax
#### - [:punct:]: !"#$%&'()*+,-.
#### /:;<=>?@[\]^_`{|}~
gsub("[[:punct:]]","", Dream5)
#### - 숫자를 *** Email[1:10]
gsub("\\d+","***",Email[1:10])
## 분할(분해)
#### * strsplit: 구분자로 문자열 분할 (리스트로 출력)
# 경로포함된 파일명에서 파일명만 가져오기: lapply, sapply
paths <- c("/home/mike/trials.csv", "/home/mike/data/errors.csv", "/home/mike/corr/reject.doc")
test <- strsplit(paths,"/")
test[[1]]
length(test[[1]])
# filenames <- NULL
# for (i in 1:3)
# filenames <- c(filenames,test[[i]][length(test[[i]])])
# filenames
## Email에서 naver.com의 메일리스트
n <- length(Email)
test <- strsplit(Email,"@")
test[[1]][2]
#### - 각 리스트의 두번째 원소: lapply, sapply
emaillist <- NULL
for (i in 1:n) if (test[[i]][2]=="naver.com")
  emaillist <- c(emaillist,test[[i]][1])
emaillist[1:10]
#### * substr: 하위문자열 추출함수
test <- "Statistics"
substr(test,1,4)
n <- nchar(Email)
substr(Email,n-8,n)[1:10]
# test <- ifelse(substr(Email,n-8,n)=="naver.com",substr(Email,1,n-10),NA)
# test[!is.na(test)][1:10]
#### * grep(문자열,문자벡터,value=F,invert=F,ignore.case=F, fixed=F)
#### ignore.case = F : 대소문자 구별하지 함
#### fixed = T: 문자열과 정확하게 일치하는 것만 출력
grep("naver.com",Email[1:10])
grep("naver.com",Email[1:10],value=T)
grep("naver.com",Email[1:10],invert=T,value=T) # not match
## 문자열 연결
## * paste: 문자열 연결함수
#### - 개별문자열에 추가
paste("To",Email[1:10])
paste("To",Email[1:10],sep=":")
paste("To",Email[1:10],sep="")
#### - 하나의 문자열로 연결
Mails <- paste(Email[1:10],collapse=", ")
test <- strsplit(Mails,",")[[1]]
## 공백제거: str_trim(x, side=c("both","left","right"))
gsub(" ","",test)
# install.packages("stringr")
# library(stringr)
stringr::str_trim(test,side="left")
## 대문자를 소문자로: tolower()
## 소문자를 대문자로: toupper()
toupper(Dreams[2])
tolower(Dreams[2])
## 문자벡터와 문자벡터 결합:(숫자도 가능)
### 단순히 결합: c()
### 중복인 경우 하나만 출력(수치형가능): union()
### 중복인 것만 출력(수치형가능): intersect()
### x에 y에 없는 것만 출력(수치형가능): setdiff(x,y)
### 순서관계없이 동일여부 확인: setequal(x,y)
X = c("A","B","C")
Y <- c("B","A","D")
c(X,Y)
union(X,Y)
intersect(X,Y)
setdiff(X,Y)
setequal(X,Y)