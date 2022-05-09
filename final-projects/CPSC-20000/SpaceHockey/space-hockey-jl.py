import pygame
import time
from pygame.locals import *

pygame.init()
#define colors used in game
white = (255,255,255)
black = (0,0,0)
green = (0,150,0)
red = (255,0,0)
blue = (0,0,255)
light_blue = (147,251,253)
yellow = (255,255,0)

#Clock set up
clock= pygame.time.Clock()
#Game Window Size
screen= pygame.display.set_mode((800,600))
#Create Center Line
divline1 = screen.get_width()/2, 0
divline2 = screen.get_width()/2 ,screen.get_height()
#Window Title + Instructions
pygame.display.set_caption('Space Hockey! Press p for instructions')
#Set Font Sizes
smallfont = pygame.font.SysFont("comicsansms" , 25)
medfont = pygame.font.SysFont("comicsansms" , 45)
largefont = pygame.font.SysFont("comicsansms" , 65)

#Create Game Objects
goalheight = 50
goalwidth = 10
goal1 = pygame.Rect(0,screen.get_height()/2 - 50,5,100)
goal2 = pygame.Rect(screen.get_width()-5,screen.get_height()/2 - goalheight,10,100)
paddle1= pygame.Rect(screen.get_width()/2-200,screen.get_height()/2,20,20)
paddle2= pygame.Rect(screen.get_width()/2+200,screen.get_height()/2,20,20)
paddleVelocity= 4
puck= pygame.Rect(screen.get_width()/2,screen.get_height()/2,20,20)
puckVelocity= [5,5]
#Import images used in the Game
img = pygame.image.load('./puck.png')
background = pygame.image.load('./background.jpg')
bluepadimg = pygame.image.load('./paddle1.png')
redpadimg = pygame.image.load('./paddle2.png')


#Set Scoreboard and Respawn Direction
score1,score2 = 0,0
serveDirection=1

def resetPuck():
    puckVelocity[0]=5*serveDirection
    puckVelocity[1]=5*serveDirection
    print(score1,score2)
    puck.x= screen.get_width()/2
    puck.y= screen.get_height()/2

def text_objects(text,color,size):
    if size == "small":
        textSurface = smallfont.render(text , True , color)
    elif size == "medium":
        textSurface = medfont.render(text , True , color)   
    elif size == "large":
        textSurface = largefont.render(text , True , color) 
    return textSurface , textSurface.get_rect()
# Pause Screen
def pause():
    paused = True
    message_to_screen("Paused",green,-110,size="large")
    message_to_screen("Player 1 use WASD keys------Player 2 use arrow keys", green, 95)
    message_to_screen("Press c to continue , q to quit",green,125)
    pygame.display.update()
    while paused:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()

            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_c:
                    paused = False

                elif event.key == pygame.K_q:
                    pygame.quit()
                    quit()
        clock.tick(5)    

def message_to_screen(msg,color,y_displace=0,x_displace=0,size = "small"):
    textSurf, textRect = text_objects(msg,color,size)
    textRect.center = (screen.get_width()/2+x_displace) , ((screen.get_height()/2) + y_displace)
    screen.blit(textSurf,textRect)

#Main Game Loop
def gameLoop():
    gameExit = False
    gameOver = False
    score2,score1=0,0
    pygame.key.stop_text_input()
    while not gameExit:
        #Movement Keys Set Up
        for event in pygame.event.get():
            down2,up2,up,down,left2,right2,right,left=0,0,0,0,0,0,0,0                
            print(event)
            if event.type == pygame.QUIT:
                gameExit = True
            if event.type == pygame.KEYDOWN:
                keys = pygame.key.get_pressed()
                if keys[K_LEFT]:
                    left = 1
                elif keys[K_RIGHT]:
                    right = 1
                elif keys[K_UP]:
                    up = 1
                elif keys[K_DOWN]:
                    down = 1
                elif keys[pygame.K_a]:
                    left2 = 1
                elif keys[pygame.K_d]:
                    right2 = 1   
                elif keys[pygame.K_w]:
                    up2 = 1
                elif keys[pygame.K_s]:
                    down2 = 1 
                elif keys[K_p]:
                    pause()             


        #Paddle1 Velocity and Build
        paddle1.y+=(down2-up2)*paddleVelocity
        paddle1.x+=(right2-left2)*paddleVelocity
        if paddle1.y<0:
            paddle1.y=0
        elif paddle1.y>screen.get_height()-  paddle1.height:
            paddle1.y=screen.get_height()-  paddle1.height
        if paddle1.x<0:
            paddle1.x=0
        elif paddle1.x>screen.get_width()/2- paddle1.width:
            paddle1.x= screen.get_width()/2- paddle1.width

        #Paddle2 Velocity and Build
        paddle2.y+= (down-up)*paddleVelocity
        paddle2.x+= (right-left)*paddleVelocity
        if paddle2.y<0:
            paddle2.y=0
        elif paddle2.y>screen.get_height()-  paddle2.height:
            paddle2.y=screen.get_height()-  paddle2.height
        if paddle2.x>screen.get_width()- paddle1.width:
            paddle2.x= screen.get_width()- paddle1.width
        elif paddle2.x<screen.get_width()/2:
            paddle2.x= screen.get_width()/2

        #Puck Build and Interactions
        puck.x+=puckVelocity[0]
        puck.y+=puckVelocity[1]
        if (puck.x <=5) and (puck.y <= screen.get_height()/2 + goalheight) and (puck.y >= screen.get_height()/2 - goalheight):
            score2+=1
            serveDirection=-1
            resetPuck()
        elif (puck.x >= screen.get_width()-goalwidth-puck.width) and (puck.y <= screen.get_height()/2 + goalheight) and (puck.y >= screen.get_height()/2 - goalheight):
            score1+=1
            serveDirection=1
            resetPuck()
        elif puck.x - 10 < 0 or puck.x + 25 > screen.get_width() :
            puckVelocity[0]*=-1;    

        if puck.y - 10 < 0  or puck.y + 10 > screen.get_height() - puck.height:
            puckVelocity[1]*=-1
        if puck.colliderect(paddle1) or puck.colliderect(paddle2):
            puckVelocity[0]*=-1


        #Game color display
        screen.fill((0,0,0))
        screen.blit(background,(0,0))
        message_to_screen("Player 1",white,-250,-150,"small")
        message_to_screen(str(score1),white,-200,-150,"small")
        message_to_screen("Player 2",white,-250,150,"small")
        message_to_screen(str(score2),white,-200,150,"small")
        pygame.draw.rect(screen, (255,100, 100), paddle1)
        pygame.draw.rect(screen, (20,20,100), paddle2)  
        pygame.draw.rect(screen,yellow,goal1)
        pygame.draw.rect(screen,yellow,goal2)  
        screen.blit(img,(puck.x,puck.y))   
        screen.blit(bluepadimg,(paddle1.x-5,paddle1.y-5))
        screen.blit(redpadimg,(paddle2.x-5,paddle2.y-5))
        #Borders, Center Line, and Circle
        pygame.draw.circle(screen, white , (screen.get_width()/2, screen.get_height()/2), screen.get_width()/10,5)
        pygame.draw.line(screen , white , divline1, divline2 ,5 )
        pygame.draw.line(screen, blue,(0,0), (screen.get_width()/2 - 5,0) ,5)
        pygame.draw.line(screen, blue,(0,screen.get_height()), (screen.get_width()/2 - 5,screen.get_height()) ,5)
        pygame.draw.line(screen, red, (screen.get_width()/2+5,0), (screen.get_width() ,0) ,5)
        pygame.draw.line(screen, red, (screen.get_width()/2 + 5,screen.get_height()) , (screen.get_width(),screen.get_height()) ,5)
        pygame.draw.line(screen, blue, (0,0), (0,screen.get_height()/2-goalheight) ,5)
        pygame.draw.line(screen, blue, (0,screen.get_height()/2 + goalheight), (0,screen.get_height()) ,5)
        pygame.draw.line(screen, red, (screen.get_width(),0), (screen.get_width(),screen.get_height()/2-goalheight) ,5)
        pygame.draw.line(screen, red, (screen.get_width(),screen.get_height()/2 + goalheight), (screen.get_width(),screen.get_height()) ,5)
        pygame.display.update()
        clock.tick(50)
gameLoop()  
