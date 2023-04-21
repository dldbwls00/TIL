import turtle
import easygui

turtle.setup(width=800, height=800)
t=turtle.Pen()

shape = easygui.buttonbox("모양을 선택하세요", choices=['circle', 'rectangle'])
num = int(easygui.enterbox("개수를 입력하세요"))
if shape == 'circle':
    for i in range(num):
        t.circle(20)
        t.up()
        t.forward(40)
        t.down()
elif shape == 'rectangle':
    for i in range(num):
        for j in range(4):
            t.forward(50)
            t.right(90)
        t.up()
        t.forward(50)
        t.down()
        
