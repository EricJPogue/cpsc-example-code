import random
import string

words = ['hello', 'goodbye'] #Defines what words will be in the wordsearch

 
gridSize = 17 #Defines Grid size

grid = [ [ '_' for _ in range(gridSize) ] for _ in range(gridSize) ] # Defines the grid as being 17 characters in length for both the y and x direction

def print_grid():
    for x in range(gridSize):
        print('\t' *7 + ' '.join( grid[x] )) # The purpose of this function is the print the grid of 17x17, and have each character be _

orientations = [ 'left-right', 'up-down', 'diagonal-up', 'diagonal-down'] #This is a list of constants used to define potential directions of each word, as well as their reverse

for word in words:
    word_length = len(word) #Defines the length of each individual word
    placed = False
    while not placed:

        orientation = random.choice(orientations) #This randomly chooses a direction that word will take
        #The below if statements define what each direction means exactly
        if orientation == 'left-right':
            stepX = 1
            stepY = 0
        if orientation == 'up-down':
            stepX = 0
            stepY = 1
        if orientation == 'diagonal-down':
            stepX = 1
            stepY = 1
        if orientation == 'diagonal-up':
            stepX = 1
            stepY = -1
        x_position = random.randint(0, gridSize) #These 2 variables randomly choose where on the grid a word will be placed
        y_position = random.randint(0, gridSize)

        ending_x = x_position + word_length*stepX #These 2 variables calculate the exact coordinates will each word will end
        ending_y = y_position + word_length*stepY

        if ending_x < 0 or ending_x >= gridSize: continue #These 2 if statements ensure that the words will not end off the grid
        if ending_y < 0 or ending_y >= gridSize: continue

        failed = False

        for i in range(word_length): #This ensures that _ characters are replaced with words from the word list. If the word cannot be placed on the list, then wordsearch will break this loop
            character = word[i]
            new_position_x = x_position + i*stepX
            new_position_y = y_position + i*stepY
            character_at_new = grid[new_position_x][new_position_y]
            if character_at_new != '_':
                if character_at_new == character:
                    continue
                else:
                    failed = True
                    break
        if failed: # Will continue cycle until all words are placed
            continue
        else:
            for i in range(word_length): 
                character = word[i]
                new_position_x = x_position + i*stepX
                new_position_y = y_position + i*stepY
                grid[new_position_x][new_position_y] = character
            placed = True    #Confirms words to be placed

for x in range(gridSize): #This for statement replaces all remaining _ with random uppercase letters
    for y in range(gridSize):
        if ( grid[x][y] == '_'):
            grid[x][y] = random.choice(string.ascii_uppercase)

print_grid()    #Uses the initial function, now that all _ are replaced with either the words, or random letters
print("The Words you have to find are:")
print(words) #This will tell the user what words are to be found within the wordsearch