# TurtleDrawLite - Part 2
# Reading a text file line by line.
#
# By: Eric Pogue
#
# All rights reserved.

TEXTFILENAME = 'turtle-draw.txt'

print('TurtleDrawLite - Part 2')
print('Reading a text file line by line.')

turtleDrawTextfile = open(TEXTFILENAME, 'r')
line = turtleDrawTextfile.readline()
while line:
	print(line, end='')
	line = turtleDrawTextfile.readline()

print('End')