import numpy as np
Intro =  '''Welcome to SudokuSolver! This program will allow you to find mutliple answers to you Suduko puzzle if you are ever
stuck on a piece! Depending on the difficulty of the puzzle, ad how many numbers are provided initally, there will be
multiple answers to a sudoku! If you would like to see those other answers, you will have the option to, but other than that,
'''
print(Intro)
sudokugrid = [[0,3,0,0,0,0,0,0,0],
        [6,0,0,1,0,0,0,0,0],
        [0,9,8,0,0,0,0,6,0],
        [8,0,0,0,6,0,0,0,3],
        [4,0,0,8,0,3,0,0,1],
        [7,0,0,0,2,0,0,0,6],
        [0,6,0,0,0,0,2,8,0],
        [0,0,0,0,1,9,0,0,5],
        [0,0,0,0,0,0,0,0,0]]
#looked up medium difficulty problem on sodoku.com
def verify(row, column, number):
    global sudokugrid
    for i in range(0,9):
        if sudokugrid[row][i] == number:
            return False
 #verifies that the number that will satisfy the space is not in the same row
    for i in range(0,9):
        if sudokugrid[i][column] == number:
            return False
 #verifies that the number that will satisfy the space is now in the same vrtical column
    x = (column // 3) * 3
    y = (row // 3) * 3
    for i in range(0,3):
        for j in range(0,3):
            if sudokugrid[y+i][x+j] == number:
                return False
#verifies that the number that will satisfy is not within the same 3x3 square
    return True
#if all conditions are met, the number is implimented in the 0 square
def solvesudoku(): #if matix is equal to 0, then the sapce is "empty" and must be filled by a certian number
    global sudokugrid
    for row in range(0,9):
        for column in range(0,9):
            if sudokugrid[row][column] == 0:
                for number in range(1,10):
                    if verify(row, column, number):
                        sudokugrid[row][column] = number
                        solvesudoku()
                        sudokugrid[row][column] = 0
                return
# def solve usues possibilites function to weed out any answers/numbers that will not satisfy the square
#uses back tracking to see if a certain number will fit in a square, and if it does it will fill the 0 in with that
#but if later, the number is incorrect, the program will go back and try a new number
    print(np.matrix(sudokugrid))
    while True:
        res = (input('Would you like to see more solutions? (y/n): '))
        if res == 'y':
            break
        if res == 'n':
            quit()
#allows the user to have an option on whther or not they want to know the other solutions
solvesudoku()
