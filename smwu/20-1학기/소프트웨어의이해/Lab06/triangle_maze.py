import turtle

turtle.setup(width=500, height=500)
t=turtle.Pen()
t.width(3)
t.setheading(60)

colorlist=["red", "green", "blue", "black"]

for i in range(0,201,7):
    t.pencolor(colorlist[i%4])
    t.forward(i)
    t.right(120)
