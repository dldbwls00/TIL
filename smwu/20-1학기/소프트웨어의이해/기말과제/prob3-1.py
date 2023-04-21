#컴퓨터과학과 2016133 이유진
print("컴퓨터과학과 2016133 이유진")
print()

from tkinter import*
import time
tk=Tk()

kor=[]
eng=[]
math=[]
name=[]

student=[]

def printmenu():
    print("1. 입력파일명 입력")
    print("2. 막대그래프 그리기")
    print("3. 종료")

def wrong(): 
    print("잘못된 순서 또는 잘못된 선택입니다.")
    print()
    printmenu()
    
printmenu()
filename=''

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
        
        canvas=Canvas(tk, width=1200, height=800)
        canvas.pack()
        
        canvas.create_line(100, 600, 1100, 600) #축 그리기
        canvas.create_line(100, 100, 100, 600)
        for j in range(10):
            canvas.create_text(92, 100+j*50, text=str((10-j)*10)+'-')
            
        canvas.create_rectangle(150, 50, 250, 80, fill='blue') #인덱스 그리기
        canvas.create_rectangle(450, 50, 550, 80, fill='yellow')
        canvas.create_rectangle(750, 50, 850, 80, fill='red')
        canvas.create_text(270, 65, text='국어')
        canvas.create_text(570, 65, text='영어')
        canvas.create_text(870, 65, text='수학')
        tk.update()
          
        for k in range(len(student)):
            kor.append(student[k][1])
            eng.append(student[k][2])
            math.append(student[k][3])
            name.append(student[k][0])
        i=0
        for korean in kor: #막대그래프 국어 출력
            x1=130+i
            y1=100+(100-int(korean))*5
            x2=130+20+i
            y2=600
            canvas.create_rectangle(x1, y1, x2, y2, fill='blue')
            i+=90
        i=0
        for english in eng: #막대그래프 영어 출력
            x1=150+i
            y1=100+(100-int(english))*5
            x2=150+20+i
            y2=600
            canvas.create_rectangle(x1, y1, x2, y2, fill='yellow')
            i+=90
        i=0
        for mathmatics in math: #막대그래프 수학 출력
            x1=170+i
            y1=100+(100-int(mathmatics))*5
            x2=170+20+i
            y2=600
            canvas.create_rectangle(x1, y1, x2, y2, fill='red')
            i+=90
        tk.update()
        
        for studentname in name: #이름 출력
            for j in range(len(student)):
                canvas.create_text(165+j*90, 620, text=name[j])
        tk.update()
    elif menu==3:
        break
    
    else:
        wrong()
        continue
