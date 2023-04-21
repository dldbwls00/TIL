#컴퓨터과학과 2016133 이유진
print("컴퓨터과학과 2016133 이유진")
print()
def printmenu():
    print("1. 입력파일명 입력")
    print("2. 평균 점수 및 등수 계산하기")
    print("3. 결과 출력하기(이름순)")
    print("4. 종료")

def wrong(): #잘못된 메뉴 선택일 경우 오류메시지 출력
    print("잘못된 순서 또는 잘못된 선택입니다.")
    print()
    printmenu()
    
printmenu()
filename=''
student=[] #최종적으로 이 안에 [이름, 국어, 영어, 수학, 평균, 석차]의 리스트들이 들어감
grade=[] #평균만 뽑아서 정렬, student내의 평균과 같은지 여부를 확인해서 석차를 append
avr=0

# 무조건 1>2>3 순으로 진행 후 종료
# ex) 1>3>2>3 (x)...첫 번째 3을 입력하면 filename이 초기화됨.

while True:
    menu=int(input("메뉴를 선택하세요: "))
    
    if menu==1:
        if filename!='':
            wrong()
            continue
        
        filename=input("입력파일명: ")
        f=open(filename)
        while True:
            line=f.readline()
            if len(line)==0:
                break
            line=line.strip()
            line=line.split(",")
            student.append(line)
        f.close()
        continue

    elif menu==2:
        if filename=='':
            wrong()
            continue
        
        a=0
        for i in student:
            avr=int(int(student[a][1])+int(student[a][2])+int(student[a][3]))/3
            student[a].append(avr)
            grade.append(avr) #평균만 따로 뽑는다
            a+=1
        grade.sort(reverse=True) #평균만 뽑은 리스트 정렬(등수를 만들기 위해)
        for b in range(len(student)):
            for i in range(len(student)):
               if student[b][4]==grade[i]:
                   student[b].append(i+1) #만든 등수 student리스트에 넣기
        continue

    elif menu==3:
        if filename=='':
            wrong()
            continue
        elif avr==0:
            wrong()
            filename='' #잘못된 메뉴 선택했을 때 오류메시지 출력을 위한 초기화  
            continue
        
        student.sort() #이름순 정렬
        print("     이름     국어    영어    수학    평균     석차")
        for i in range(len(student)):
            print("    %s     %s     %s      %s     %.1f     %2d" % (student[i][0], student[i][1], student[i][2], student[i][3], student[i][4], student[i][5])) 
        filename='' #잘못된 메뉴 선택했을 때 오류메시지 출력을 위한 초기화  
        continue

    elif menu==4:
        break

    else:
        wrong()
        continue
    
        


