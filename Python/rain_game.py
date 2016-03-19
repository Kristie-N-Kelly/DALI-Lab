import pygame, random, math, os
pygame.init()
win = pygame.display.set_mode((600,600))
h = win.get_height()
w = win.get_width()
sw = w/40
sh = h/40
r = sw/3

green = (0,102,0)
black = (0,0,0)
red =  (255,0,0)
white = (255,255,255)
yellow = (249,255,34)
blue = (0,0,255)

#initialize player properties
x = 2*sw
y = h - (sh*16)

#initialize sun dot properties
x2 = []
y2 = []
color = []

#initialize rain properties
ry = []
rx = []
rdy = []


#load images
basePath = os.path.dirname(__file__)
cloudPath = os.path.join(basePath, "cloud.png")
cloud = pygame.image.load(cloudPath)

basePath2 = os.path.dirname(__file__)
groundPath = os.path.join(basePath2, "ground.png")
ground = pygame.image.load(groundPath)

basePath3 = os.path.dirname(__file__)
umbrellaPath = os.path.join(basePath3, "man.png")
umbrella = pygame.image.load(umbrellaPath)

basePath4 = os.path.dirname(__file__)
umbrella2Path = os.path.join(basePath4, "man_copy.png")
umbrella2 = pygame.image.load(umbrella2Path)


#have text on screen
font = pygame.font.SysFont("Courier New", 20)
score = font.render(str("Score:"), True, (0,0,0))

#maximum number of sun dots one can collect
def initialize (n):
    for i in range (n):
        x2.append(random.randrange ((sw*5),w - (sw*5) ,15))
        y2.append(random.randrange (sh*11,(h-(sh*9)),15))
        color.append(yellow)

#initializing rain drops
def fall (n):
    for i in range (n):
        rx.append(random.randrange (((sw*5) + (sw/2)),(w - (sw*5) - (sw/2)),15))
        rdy.append (random.random()+ 1)
        ry.append(78)

#constrain where player can move    
def keep (x,y):
    if x < 0:
        x = 0
    if y < sh*11:
        y = sh*11
    if x > w - sw:
        x = w - sw
    if y > h - sh*9:
        y = h - sh*9
    return (x,y)

#making rain drops fall
def raining (x,y):
    i = 0
    while i < (len(ry)):
        ry[i] = ry[i] + rdy[i]
        if ry[i] > h:
             del rx[i], ry[i], rdy [i]
             fall(1)
        else:
            pygame.draw.circle (win, blue, (int(rx[i]),int(ry[i])),r)
            i = i + 1

#checking to see if you die
def die (x,y):
    j = 0
    game_running = True
    while j <(len(rx))and game_running:
        if rx[j] > x and ry[j] > y and rx[j] < (x+sw) and ry[j] < (y+sh):
            game_running = False
        else:
            j = j + 1
    return game_running
    
  
# M A I N    P R O G R A M  

initialize (300)
fall (20)

pygame.key.set_repeat (50,(1/2))
game_running = True
count = 0
while game_running:
    
    #constrain player
    (x,y) = keep (x,y)
    
    #display the safe areas, sky, ground 
    pygame.draw.rect (win,(167,250,164), (0, 0,(5*sw),h))
    pygame.draw.rect (win,(167,250,164), (w-(5*sw),0,(5*sw),h))
    pygame.draw.rect (win,(139,225,255), (sw*5, 0, sh*30,h))
    pygame.draw.rect (win,black,(0,163,sh*5,2))
    pygame.draw.rect (win,black,(w-(sh*5),163,sh*5,2))
    win.blit (umbrella,(1,78))
    win.blit (umbrella2,((w-(sh*5)+1,78)))
    win.blit (cloud, (sh*12,7))
    win.blit (cloud, (sh*5,4))
    win.blit (cloud, (sh*19,4))
    win.blit (ground, (sh*5,465))
    
    #display score
    win.blit (score,(2,0))
    points = font.render(str(count), True, (0,0,0))
    win.blit(points,(10,20))
    
    #display the player
    pygame.draw.rect (win,green, (x,y,sw,sh))
     
    #after a collection update your score and display the next sun dot randomly
    for i in range (len(x2)):
        pygame.draw.rect (win, color[i-i], (int (x2[i-i]), int(y2[i-i]),sw,sh))
        if (x,y) == (x2[i-i],y2[i-i]):
            count = count + 10
            del (x2[i-i],y2[i-i])
            pygame.draw.rect (win, color[i-i], (int (x2[i-i]), int(y2[i-i]),sw,sh))

    #display raindrops
    raining (x,y)
    
    #die when you hit the rain
    game_running = die (x,y)

    pygame.display.update()    
    
    #moving the player with arrow keys
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            game_running = False
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                #move left
                x = x - sw
            elif event.key == pygame.K_RIGHT:
                #move right
                x = x + sw
            elif event.key == pygame.K_UP:
                #move up
                y = y - sh
            elif event.key == pygame.K_DOWN:
                #move down
                y = y + sh

print "Oh man! You got hit by a rain drop. Your final score was", count