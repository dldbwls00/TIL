##############
## R Packages
##############
## * R홈페이지 > cran > mirrors > packages에서 제공
## * 2021/12/29 현재 18653개 (참고: 20/02/20 15332개, 20/10/5 16387개) packages 제공
## Package 설치
## 설치된 패키지 확인
installed.packages()
## * 기본 패키지는 R 폴더 > library
## * 추가 패키지는 C:\Users\***\Documents\R\win-library\4.1
install.packages("xlsx") # Excel 파일 읽기
install.packages("readxl") # Excel 파일 읽기
## 설치가 안되는 경우
## * R홈페이지 > cran > mirrors > packages
## * package 선택 > r-release 압축파일 다운로드
## * RStudio: Tools메뉴 > install packages > Package Archive에서 다운로드한 파일선택
## 일부 패키지는 Java, Perl를 활용함 => 관련 컴파일러 필요
## * ex) xlsx
## JRE(JDK) 설치와 Path 지정 후
## 작업공간 상에 불러오기
? read.xlsx
require(xlsx)
? read.xlsx
detach("package:xlsx",unload=T)
? read.xlsx
? xlsx::read.xlsx
if(!require(xlsx))
{ install.packages("xlsx")
  library(xlsx)
}
## Packages Update
## * RStudio: Tools메뉴 > Check for Package Updates > 업데이트할 패키지 선택
update.packages(ask=F)
## Package 제거
# remove.packages("xlsx")
##################
## Excel 파일 읽기
##################
Data1 <- read.xlsx("Employee.xlsx", sheetName = "Employee", encoding="UTF-8") # sheetName = "data"
str(Data1) # 문자 => factor. 문자 => 문자
Data2 <- readxl::read_excel("Employee.xlsx",sheet="Employee")
str(Data2) # tbl_df, 문자 => 문자
Data2 <- readxl::read_excel("Employee.xlsx",sheet="Employee",range="B1:I10",col_names=T)
## RStudio GUI: File > import Dataset > From Excel
View(Data2)
## * Excel 파일로 저장
#### - xlsx::write.xlsx(),
#### - install.packages("writexl"); writexl::write_xlsx()