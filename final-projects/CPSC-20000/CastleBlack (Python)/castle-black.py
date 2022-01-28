import pygame
import random
import math
from pygame.constants import TIMER_RESOLUTION
from pygame import mixer

pygame.init()
mixer.init()
# Screen
width = 800
height = 600
screen = pygame.display.set_mode((width, height))

# Title
pygame.display.set_caption("Castle Black")
title_icon = pygame.image.load('castle.png')
pygame.display.set_icon(title_icon)

#score
score_value = 0
font = pygame.font.Font ('freesansbold.ttf', 32)
textX = 10
textY = 10 

# Sounds
mixer.music.load('themeMusic.wav')
mixer.music.play(-1)

spearSound = mixer.Sound('spear.wav')

canonSound = mixer.Sound('canon.wav')

greenSound = mixer.Sound('dragon1.wav')

bombSound = mixer.Sound('bombHit.wav')

dragonSound = mixer.Sound('dragon2.wav')


# Game Over 
over_font = pygame.font.Font('freesansbold.ttf', 64)

# Background
background = pygame.image.load('background.jpg')

# Player

# Knight
knightIMG= pygame.image.load("knight.png")
knightX = 370
knightY = 60
knightX_change = 0

# Spear
spearIMG = pygame.image.load('spearGame.png')
spearX = 370
spearY = 60
spearX_change = 0
spearY_change = 1
spear_state = "ready"

# Canon
canonIMG= pygame.image.load("gamecanon.png")
canonX = 10
canonY = 60
canonX_change = 0.3

# Canon Ball
bombIMG= pygame.image.load("bomb.png")
bombX = 10
bombY = 60
bombX_change = 0
bomnbY_chnage = 1
bomb_state = "ready"

# Enemies

# Green Dragon
green_DragonIMG=[]
green_DragonX=[]
green_DragonY= []
green_DragonX_change =[]
green_DragonY_change =[]
num_of_green = 4

for i in range(num_of_green):
    green_DragonIMG.append(pygame.image.load("greenDragon.png"))
    green_DragonX.append (random.randint (0,700))
    green_DragonY.append (random.randint (450,550))
    green_DragonX_change.append (0.3)
    green_DragonY_change.append (40)


# Red Dragon
red_DragonIMG = []
red_DragonX = []
red_DragonY = []
red_dragonX_change = []
red_dragonY_change = []
num_of_red = 6

for i in range(num_of_red):
    red_DragonIMG.append (pygame.image.load("redDragon.png"))
    red_DragonX.append(random.randint (0, 736))
    red_DragonY.append(random.randint (450,550))
    red_dragonX_change.append(0.4)
    red_dragonY_change.append(40)



# Verticle Dragon
verticle_DragonIMG = []
verticle_DragonX = []
verticle_DragonY = []
verticle_DragonX_change = []
verticle_DragonY_change = []
num_of_vertical = 4

for i in range (num_of_vertical):
    verticle_DragonIMG.append(pygame.image.load("redDragon.png"))
    verticle_DragonX.append(random.randint (0,800))
    verticle_DragonY.append(536)
    verticle_DragonX_change.append(0)
    verticle_DragonY_change.append(0.5)

def show_score(x, y):
    score = font.render("Score : " + str(score_value), True, (0,0,0))
    screen.blit(score, (textX, textY))

def game_over():
    over = over_font.render("GAME OVER", True, (0,0,0))
    screen.blit(over, (200, 250))

def knight(x, y):
    screen.blit(knightIMG, (x, y))

def throw_spear(x, y):
    global spear_state
    spear_state = "fire"
    screen.blit(spearIMG, (x + 16,y +10))

def canon(x, y):
    screen.blit(canonIMG, (x, y))

def fire_canon(x, y):
    global bomb_state
    bomb_state = "fire"
    screen.blit(bombIMG, (x + 16,y + 10))

def greenDragon(x, y, i):
    screen.blit(green_DragonIMG[i], (x, y))

def greenCollison(green_DragonX, green_DragonY, bombX, bombY):
    greenDistance = math.sqrt((math.pow(green_DragonX-bombX,2)) + (math.pow (green_DragonY-bombY,2)))
    if greenDistance < 50:
        return True
    else:
        return False

def redDragon(x, y, i):
    screen.blit(red_DragonIMG[i], (x, y))

def redCollision(red_DragonX, red_DragonY, spearX, spearY):
    redDistance = math.sqrt((math.pow(red_DragonX-spearX,2)) + (math.pow (red_DragonY-spearY,2)))
    if redDistance < 27:
        return True
    else:
        return False

def verticleDragon(x, y, i):
    screen.blit(verticle_DragonIMG[i], (x, y))

def verticleCollision(verticle_DragonX, verticle_DragonY, spearX, spearY):
    verticleDistance = math.sqrt((math.pow(verticle_DragonX-spearX,2)) + (math.pow (verticle_DragonY-spearY,2)))
    if verticleDistance < 27:
        return True
    else:
        return False

print("Instructions: Move your character left and right with the arrow keys. Throw spear with the space bar to kill the red dragons and fire the canon with left shift to kill the green dragons.")
print("If they touch you, you lose. Good luck!")

running = True
while running:

    screen.fill((255, 255, 255))
    screen.blit(background ,(0,0))

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                knightX_change = -0.3
            elif event.key == pygame.K_RIGHT:
                knightX_change = 0.3
            elif event.key == pygame.K_SPACE:
                if spear_state is 'ready':
                    spearSound.play()
                    spearX = knightX
                    throw_spear(spearX, spearY)
            elif event.key == pygame.K_LSHIFT:
                if bomb_state is 'ready':
                    canonSound.play()
                    bombX = canonX
                    fire_canon(bombX, bombY)

        if event.type == pygame.KEYUP:
            if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                knightX_change = 0
        

            
    #Player Movement
    knightX += knightX_change
    if knightX <= 0:
        knightX = 0
    if knightX >= 736:
        knightX = 736
    knight(knightX, knightY)

    # spear Movement
    if spearY >= 600:
        spearY = 60
        spear_state = "ready"

    if spear_state is "fire":
        throw_spear(spearX, spearY)
        spearY += spearY_change
        
 
    # Canon Movement
    canonX += canonX_change

    if canonX <= 0:
        canonX_change = 0.3
    if canonX >= 736:
        canonX_change = -0.3
    canon(canonX, canonY)

    # Bomb Movement
    if bombY >= 600:
        bombY = 60
        bomb_state = "ready"

    if bomb_state is "fire":
        fire_canon(bombX, bombY)
        bombY += bomnbY_chnage

    # Green Dragon Movement
    for i in range(num_of_green):
        green_DragonX[i] += green_DragonX_change[i]

        if green_DragonX[i] <= 0:
            green_DragonX_change[i] = 0.3
            green_DragonY[i] -= green_DragonY_change[i]
        elif green_DragonX[i] >= 675:
            green_DragonX_change[i] = -0.3
            green_DragonY[i] -= green_DragonY_change[i]

        # Green Collision
        green_collision = greenCollison(green_DragonX[i], green_DragonY[i], bombX, bombY)
        if green_collision:
            bombSound.play()
            greenSound.play()
            bombY = 60
            bomb_state = "ready"
            score_value += 1
            green_DragonX[i] = random.randint (0,625)
            green_DragonY[i] = random.randint (450,525)

        # Game End
        green_end_distance = math.sqrt((math.pow(green_DragonX[i]-knightX,2)) + (math.pow (green_DragonY[i]-knightY,2)))
        if green_end_distance < 27:
            knightY = 2000
            canonY = 2000

        greenDragon(green_DragonX[i], green_DragonY[i], i)


    for i in range (num_of_red):
    # Red Dragon Movement
        red_DragonX[i] += red_dragonX_change[i]

        if red_DragonX[i] <= 0:
            red_dragonX_change[i] = 0.3
            red_DragonY[i] -= red_dragonY_change[i]
        if red_DragonX[i] >= 736:
            red_dragonX_change[i] = -0.3
            red_DragonY[i] -= red_dragonY_change[i]

        # Red Dragon Collision
        red_collision = redCollision(red_DragonX[i], red_DragonY[i], spearX, spearY)
        if red_collision:
            greenSound.play()
            spearY = 60
            spear_state = "ready"
            score_value += 1
            red_DragonX[i] = random.randint (0,700)
            red_DragonY[i] = random.randint (450,525)

        redDragon(red_DragonX[i], red_DragonY[i], i)

    # Verticle Dragon Movement
    for i in range (num_of_vertical):
        verticle_DragonY[i] -= verticle_DragonY_change[i]

        if verticle_DragonY[i] <= 0:
            verticle_DragonY[i] = 536
            verticle_DragonX[i] = random.randint (0, 736)

        # Verticle Dragon Collision
        verticle_collision = verticleCollision(verticle_DragonX[i], verticle_DragonY[i], spearX, spearY)
        if verticle_collision:
            dragonSound.play()
            spearY = 60
            spear_state = "ready"
            score_value += 1
            verticle_DragonX[i] = random.randint (0,800)
            verticle_DragonY[i] = 536
        
        verticle_end_distance = math.sqrt((math.pow(verticle_DragonX[i]-knightX,2)) + (math.pow (verticle_DragonY[i]-knightY,2)))
        if verticle_end_distance < 27:
            knightY = 2000
            canonY = 2000

        verticleDragon(verticle_DragonX[i], verticle_DragonY[i], i)

    if knightY == 2000:
        game_over()


    show_score(textX, textY)
    pygame.display.update()