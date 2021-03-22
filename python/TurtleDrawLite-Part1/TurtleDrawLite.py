# TurtleDrawLite
#
# By: Eric Pogue
# Credits: Dr. Ray Klump
#
# All rights reserved.
#
# Note: Many more example can be found by searching “python turtle example” including:
#      https://michael0x2a.com/blog/turtle-examples
#      https://realpython.com/beginners-guide-python-turtle

import turtle

def processLine(line):
	print(line)



print('Turtle Draw Lite Starting...')


f = open("turtle-draw.txt", "r")
fileContent = f.read()
print(fileContent)
print('testing open and read.')


'''
edTheTurtle = turtle.Turtle()
edTheTurtle.forward(100)
edTheTurtle.right(90)
edTheTurtle.forward(100)
edTheTurtle.right(90)
edTheTurtle.forward(100)
edTheTurtle.right(90)
edTheTurtle.forward(100)
'''

spiral = turtle.Turtle()
spiral.pencolor("purple")
for i in range(40):
    spiral.forward(i * 10)
    spiral.right(144)

turtle.done()