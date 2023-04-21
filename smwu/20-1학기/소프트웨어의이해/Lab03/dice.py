import easygui
import random

name = easygui.enterbox("Write your name")
easygui.buttonbox("Play rolling a dice", choices=['Roll'])

s = 0
times = 2

while times > 0:
    dice = random.randint(1,6)
    easygui.buttonbox("You got "+str(dice)+"\n"+str(times)+" times left", \
                      choices=['Roll'])

    s += dice
    times = times -1
    
if times == 0:
    easygui.buttonbox("You got "+str(dice)+"\nNo more chance..", \
                    choices=['Show the result'])
s += dice

c = random.randint(3,18)

if s>c:
    answer="You win!"
elif s<c:
    answer="You lose..."

easygui.msgbox(name+"'s Fianl score : "+str(s)+"\nComputer score : "+str(c)+"\n"+answer)
    
    
