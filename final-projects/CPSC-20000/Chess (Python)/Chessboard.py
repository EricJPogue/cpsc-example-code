from tkinter import *

root=Tk()

#Variables for draw_board()
rows = 8
columns = 8
color1 = "#ff3333" #Red_orange
color2 = "#ff9999" #Light_Salmon_pink
dim_square = 64
tile_center = dim_square/2
tiles=8
FEN_file="FEN_board.lvl"

#Variables for get_position()
x1=0
y1=0
x2=0
y2=0
clic=0
tour=0
tb=1800
tw=1800
clic1=0

selectedPiece = "";

#Variables for pieces
#k == King
#q == queen
#r == Rook
#b == Bishop
#n == Knight
#p == Pawn
#Import Images Black Piece
blackb1=PhotoImage(file="./pieces_image/blackb.gif")
blackb2=PhotoImage(file="./pieces_image/blackb.gif")
blackk=PhotoImage(file="./pieces_image/blackk.gif")
blackn1=PhotoImage(file="./pieces_image/blackn.gif")
blackn2=PhotoImage(file="./pieces_image/blackn.gif")
blackp1=PhotoImage(file="./pieces_image/blackp.gif")
blackp2=PhotoImage(file="./pieces_image/blackp.gif")
blackp3=PhotoImage(file="./pieces_image/blackp.gif")
blackp4=PhotoImage(file="./pieces_image/blackp.gif")
blackp5=PhotoImage(file="./pieces_image/blackp.gif")
blackp6=PhotoImage(file="./pieces_image/blackp.gif")
blackp7=PhotoImage(file="./pieces_image/blackp.gif")
blackp8=PhotoImage(file="./pieces_image/blackp.gif")
blackq=PhotoImage(file="./pieces_image/blackq.gif")
blackr1=PhotoImage(file="./pieces_image/blackr.gif")
blackr2=PhotoImage(file="./pieces_image/blackr.gif")
#Import Images White Piece
whiteb1=PhotoImage(file="./pieces_image/whiteb.gif")
whiteb2=PhotoImage(file="./pieces_image/whiteb.gif")
whitek=PhotoImage(file="./pieces_image/whitek.gif")
whiten1=PhotoImage(file="./pieces_image/whiten.gif")
whiten2=PhotoImage(file="./pieces_image/whiten.gif")
whitep1=PhotoImage(file="./pieces_image/whitep.gif")
whitep2=PhotoImage(file="./pieces_image/whitep.gif")
whitep3=PhotoImage(file="./pieces_image/whitep.gif")
whitep4=PhotoImage(file="./pieces_image/whitep.gif")
whitep5=PhotoImage(file="./pieces_image/whitep.gif")
whitep6=PhotoImage(file="./pieces_image/whitep.gif")
whitep7=PhotoImage(file="./pieces_image/whitep.gif")
whitep8=PhotoImage(file="./pieces_image/whitep.gif")
whiteq=PhotoImage(file="./pieces_image/whiteq.gif")
whiter1=PhotoImage(file="./pieces_image/whiter.gif")
whiter2=PhotoImage(file="./pieces_image/whiter.gif")

pieces=[blackb1,blackb2,blackk,blackn1,blackn2,blackp1,blackp2,blackp3,blackp4,blackp5,blackp6,blackp7,blackp8,blackq,blackr1,blackr2,whiteb1,whiteb2,whitek,whiten1,whiten2,whitep1,whitep2,whitep3,whitep4,whitep5,whitep6,whitep7,whitep8,whiteq,whiter1,whiter2]

w, h = 8, 8

board = [["" for x in range(w)] for y in range(h)]

board[0][0] = "blackr1"
board[0][1] = "blackn1"
board[0][2] = "blackb1"
board[0][3] = "blackq"
board[0][4] = "blackk"
board[0][5] = "blackb2"
board[0][6] = "blackn2"
board[0][7] = "blackr2"
board[1][0] = "blackp1"
board[1][1] = "blackp2"
board[1][2] = "blackp3"
board[1][3] = "blackp4"
board[1][4] = "blackp5"
board[1][5] = "blackp6"
board[1][6] = "blackp7"
board[1][7] = "blackp8"
board[6][0] = "whitep1"
board[6][1] = "whitep2"
board[6][2] = "whitep3"
board[6][3] = "whitep4"
board[6][4] = "whitep5"
board[6][5] = "whitep6"
board[6][6] = "whitep7"
board[6][7] = "whitep8"
board[7][0] = "whiter1"
board[7][1] = "whiten1"
board[7][2] = "whiteb1"
board[7][3] = "whiteq"
board[7][4] = "whitek"
board[7][5] = "whiteb2"
board[7][6] = "whiten2"
board[7][7] = "whiter2"

    

canvas=Canvas(root, width=512, height=512)
canvas.pack(expand=1, fill=BOTH)

board_representation=[]
for i in range(tiles):
      board_representation.append([""]*tiles)

def FEN_file_check(fname):
   try:
      f = open(fname,'r')
      f.close()
      return True
   except:
      return False

def interpretor(line):
   i,j=0,0
   print(line)
   
   for letter in line:
      if letter=="r" or letter=="n" or letter=="b" or letter=="q" or letter=="k" or letter=="p" or letter=="R" or letter=="N" or letter=="B" or letter=="Q" or letter=="K" or letter=="P":  
         board_representation[i][j]=letter
         for p in pieces:
            piecesx=i
            piecesy=j
      
      if i<tiles-1:
         i=i+1
      elif j<tiles-1:
         j=j+1
         i=0

def display_game(turn):
   canvas.delete(ALL)
   draw_chessboard()
   draw_pieces()
   i,j=0,0
   for i in range(tiles):
      for j in range(tiles):
         board_representation[i][j]=" "
   if FEN_file_check(FEN_file):
      fich=open(FEN_file,"r")
      i= 1
      while i<=turn:
         line=fich.readline()
         i=i+1
      if line =="":
            messagebox.showinfo("ERROR, EMPTY FILE !")
      else :
            interpretor(line)
            fich.close
            canvas.bind('<Button-1>', move_image)
            canvas.bind('<Button-1>', get_position, add="+")
   else:
      messagebox.showerror("ERROR","FILE NOT FOUND !")

def refresh():
   i,j=0,0
   for i in range(tiles):
      for j in range(tiles):
         if board_representation[i][j]=="r" :
            canvas.create_image(tile_center+i*dim_square,tile_center+j*dim_square,image=blackr)
            canvas.pack()
         elif board_representation[i][j]=="n" :
            canvas.create_image(tile_center+i*dim_square,tile_center+j*dim_square,image=blackn)
            canvas.pack()
         elif board_representation[i][j]=="b" :
            canvas.create_image(tile_center+i*dim_square,tile_center+j*dim_square,image=blackb)
            canvas.pack()
         elif board_representation[i][j]=="q" :
            canvas.create_image(tile_center+i*dim_square,tile_center+j*dim_square,image=blackq)
            canvas.pack()
         elif board_representation[i][j]=="k" :
            canvas.create_image(tile_center+i*dim_square,tile_center+j*dim_square,image=blackk)
            canvas.pack()
         elif board_representation[i][j]=="p" :
            canvas.create_image(tile_center+i*dim_square,tile_center+j*dim_square,image=blackp)
            canvas.pack()
         elif board_representation[i][j]=="R" :
            canvas.create_image(tile_center+i*dim_square,tile_center+j*dim_square,image=whiter)
            canvas.pack()
         elif board_representation[i][j]=="N" :
            canvas.create_image(tile_center+i*dim_square,tile_center+j*dim_square,image=whiten)
            canvas.pack()
         elif board_representation[i][j]=="B" :
            canvas.create_image(tile_center+i*dim_square,tile_center+j*dim_square,image=whiteb)
            canvas.pack()
         elif board_representation[i][j]=="Q" :
            canvas.create_image(tile_center+i*dim_square,tile_center+j*dim_square,image=whiteq)
            canvas.pack()
         elif board_representation[i][j]=="K" :
            canvas.create_image(tile_center+i*dim_square,tile_center+j*dim_square,image=whitek)
            canvas.pack()
         elif board_representation[i][j]=="P" :
            canvas.create_image(tile_center+i*dim_square,tile_center+j*dim_square,image=whitep)
            canvas.pack()

def move_validation(xdirection,ydirection):
   global turn
   move=False
   if board_representation[piecesx+xdirection][piecesy+ydirection]==" ":
      move=True
   if move==True:
       piecesx=piecesx+xdirection
       piecesy=piecesy+ydirection
       refresh()
  

if selectedPiece == 'selectedPiece': #The piece is a pawn.
        if not isOccupied(board,x1,y1-1) and not AttackSearch:
                #The piece immediately above is not occupied, append it.
                listofTuples.append((x1,y1-1))
                
                if y1 == 6 and not isOccupied(board,x1,y1-2):
                    #If pawn is at its initial position, it can move two squares.
                    listofTuples.append((x2,y2-2))
            
        if x!=0 and isOccupiedby(board,x-1,y-1,'selectedPiece'):
                #The piece diagonally up and left of this pawn is a black piece.
                #Also, this is not an 'a' file pawn (left edge pawn)
                listofTuples.append((x-1,y-1))
        if x!=7 and isOccupiedby(board,x+1,y-1,'black'):
                #The piece diagonally up and right of this pawn is a black one.
                #Also, this is not an 'h' file pawn.
                listofTuples.append((x+1,y-1))
        if EnP_Target!=-1: #There is a possible en pasant target:
                if EnP_Target == (x-1,y-1) or EnP_Target == (x+1,y-1):
                    #We're at the correct location to potentially perform en
                    #passant:
                    listofTuples.append(EnP_Target)
  
def draw_chessboard():
    color = color2
    for r in range(rows):
        color = color1 if color == color2 else color2
        for c in range(columns):
            x1 = (c * dim_square)
            y1 = ((7-r) * dim_square)
            x2 = x1 + dim_square
            y2 = y1 + dim_square
            canvas.create_rectangle(x1, y1, x2, y2, fill=color, tags="area")
            color = color1 if color == color2 else color2

def draw_pieces():
    canvas.create_image(32,32, image=blackr1, anchor=CENTER, state=NORMAL, tags="blackr1")
    canvas.create_image(96,32, image=blackn1, anchor=CENTER, state=NORMAL, tags="blackn1")
    canvas.create_image(159,32, image=blackb1, anchor=CENTER, state=NORMAL, tags="blackb1")
    canvas.create_image(288,32, image=blackk, anchor=CENTER, state=NORMAL, tags="blackk")
    canvas.create_image(222,32, image=blackq, anchor=CENTER, state=NORMAL, tags="blackq")
    canvas.create_image(350,32, image=blackb2, anchor=CENTER, state=NORMAL, tags="blackb2")
    canvas.create_image(411,32, image=blackn2, anchor=CENTER, state=NORMAL, tags="blackn2")
    canvas.create_image(478,32, image=blackr2, anchor=CENTER, state=NORMAL, tags="blackr2")
    canvas.create_image(33,96, image=blackp1, anchor=CENTER, state=NORMAL, tags="blackp1")
    canvas.create_image(95,96, image=blackp2, anchor=CENTER, state=NORMAL, tags="blackp2")
    canvas.create_image(159,96, image=blackp3, anchor=CENTER, state=NORMAL, tags="blackp3")
    canvas.create_image(222,96, image=blackp4, anchor=CENTER, state=NORMAL, tags="blackp4")
    canvas.create_image(286,96, image=blackp5, anchor=CENTER, state=NORMAL, tags="blackp5")
    canvas.create_image(350,96, image=blackp6, anchor=CENTER, state=NORMAL, tags="blackp6")
    canvas.create_image(419,96, image=blackp7, anchor=CENTER, state=NORMAL, tags="blackp7")
    canvas.create_image(476,96, image=blackp8, anchor=CENTER, state=NORMAL, tags="blackp8")
    canvas.create_image(31,482, image=whiter1, anchor=CENTER, state=NORMAL, tags="whiter1")
    canvas.create_image(99,482, image=whiten1, anchor=CENTER, state=NORMAL, tags="whiten1")
    canvas.create_image(156,482, image=whiteb1, anchor=CENTER, state=NORMAL, tags="whiteb1")
    canvas.create_image(224,482, image=whiteq, anchor=CENTER, state=NORMAL, tags="whiteq")
    canvas.create_image(289,480, image=whitek, anchor=CENTER, state=NORMAL, tags="whitek")
    canvas.create_image(348,482, image=whiteb2, anchor=CENTER, state=NORMAL, tags="whiteb2")
    canvas.create_image(481,482, image=whiter2, anchor=CENTER, state=NORMAL, tags="whiter2")
    canvas.create_image(416,482, image=whiten2, anchor=CENTER, state=NORMAL, tags="whiten2")
    canvas.create_image(34,419, image=whitep1, anchor=CENTER, state=NORMAL, tags="whitep1")
    canvas.create_image(97,419, image=whitep2, anchor=CENTER, state=NORMAL, tags="whitep2")
    canvas.create_image(164,419, image=whitep3, anchor=CENTER, state=NORMAL, tags="whitep3")
    canvas.create_image(226,419, image=whitep4, anchor=CENTER, state=NORMAL, tags="whitep4")
    canvas.create_image(289,419, image=whitep5, anchor=CENTER, state=NORMAL, tags="whitep5")
    canvas.create_image(352,419, image=whitep6, anchor=CENTER, state=NORMAL, tags="whitep6")
    canvas.create_image(414,419, image=whitep7, anchor=CENTER, state=NORMAL, tags="whitep7")
    canvas.create_image(477,419, image=whitep8, anchor=CENTER, state=NORMAL, tags="whitep8")
    
    
    

def get_position(event):
    global clic,x1,y1,x2,y2,tour,tb,tw,clic1,selectedPiece
    if clic==0:
        x1=event.x
        y1=event.y
        print(int(x1/dim_square),int(y1/dim_square))
        x = int(x1/dim_square)
        y = int(y1/dim_square)
        selectedPiece = board[y][x]
        print(selectedPiece)
        coordinates.delete(0.0,END)
        coordinates.insert(END,"clic detecte en x1="+str(x1)+" , y1 = " +str(y1))
        clic=1
    elif clic==1:
        x2=event.x
        y2=event.y
        print(int(x2/dim_square),int(y2/dim_square))
        x = int(x1/dim_square)
        y = int(y1/dim_square)
        coordinates.delete(0.0,END)
        coordinates.insert(END,"clic detecte en x2="+str(x2)+" , y2 = " +str(y2))
        clic=0
        
        tour=(tour+1)
        if (tour%2)==1:
            clic1=1
                
        if (tour%2)==0:
            clic1=2

def move_image(event):
    global x1,y1,x2,y2,img, init_image,closest
    init_image=[]
    if clic==0: #First Clic
        x1=event.x
        y1=event.y
        i,j=(int(x1/dim_square),int(y1/dim_square))
        print(i,j)
        closest=canvas.find_closest(x1,y1)
        t = canvas.coords(closest)
        if not t:
            return
        x1, y1 = t
        x1=int(x1)
        y1=int(y1)
        init_image.append(x1)
        init_image.append(y1)
        print(init_image)
    elif clic==1: #Second Clic
        x2=event.x
        y2=event.y
        i,j=(int(x2/dim_square),int(y2/dim_square))
        print(i,j)
        x_center,y_center=tile_center+i*dim_square,tile_center+j*dim_square
        print(x_center,y_center)
        canvas.coords(closest, x_center, y_center)


def move_image(event):
    global x1,y1,x2,y2,img, init_image,selected,selectedPiece
    init_image=[]
    if clic==0: #First Clic
        selected=x1,y1=canvas.coords("whitep1")
        closest=canvas.find_closest(x1,y1,halo=32)
        x1=int(x1)
        y1=int(y1)
        init_image.append(x1)
        init_image.append(y1)
        if not selected:
            return
        assert(len(selected) == 2)
        x1, y1 = selected
    elif clic==1: #Second Clic
        x2=event.x
        y2=event.y
        print(selectedPiece)
        if selectedPiece != "":
            newColumn = int(x2/64)
            newRow = int(y2/64)
            oldColumn = 0
            oldRow = 0
            for a in range(0,7):
                for b in range(0,7):
                    if board[a][b]==selectedPiece:
                        oldColumn = b
                        oldRow = a
            print(board[oldRow][oldColumn])
            print(board[newRow][newColumn])
            # check if the selected move is valid

			# when you hit an invalid move, return
			# return
			
            canvas.delete(selectedPiece)
            if selectedPiece == "blackr1":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackr1,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "blackn1":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackn1,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "blackb1":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackb1,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "blackq":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackq,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "blackk":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackk,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "blackb2":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackb2,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "blackn2":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackn2,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "blackr2":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackr2,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "whiter1":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whiter1,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "whiten1":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whiten1,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "whiteb1":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whiteb1,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "whiteq":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whiteq,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "whitek":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whitek,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "whiteb2":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whiteb2,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "whiten2":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whiten2,anchor=CENTER,tags=selectedPiece)
            if selectedPiece == "whiter2":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whiter2,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="blackp1":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackp1,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="blackp2":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackp2,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="blackp3":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackp3,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="blackp4":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackp4,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="blackp5":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackp5,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="blackp6":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackp6,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="blackp7":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackp7,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="blackp8":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=blackp8,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="whitep1":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whitep1,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="whitep2":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whitep2,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="whitep3":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whitep3,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="whitep4":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whitep4,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="whitep5":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whitep5,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="whitep6":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whitep6,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="whitep7":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whitep7,anchor=CENTER,tags=selectedPiece)
            if selectedPiece =="whitep8":
                canvas.create_image(int(x2/64)*64+32, int(y2/64)*64+32, image=whitep8,anchor=CENTER,tags=selectedPiece)
            for q in range(0,7):
                for w in range(0,7):
                    if board[q][w]==selectedPiece:
                        print(board[q][w])
                        print(q)
                        print(w)
                        board[q][w] = ""
            if board[newRow][newColumn] != "":
                canvas.delete(board[newRow][newColumn])
            board[newRow][newColumn]=selectedPiece
def enumerate_moves(x1, y1):

     potential_moves = [1][0],[2,0] 
     if board[x1][y1] == "blackp1":

        potential_moves.append([[x1+1], [y1]])
     try:
         if board[x+2][y] == "" and x1 == 1 and board[x1+1][y1] == "":
             potential_moves.append([[x1+2], [y1]])
     except IndexError:
        pass
                    
     try:
         if board[x1+1][y1+1][0] == "w":
             potential_moves.append([x1+1], [y1+1])
     except IndexError:
        pass

     try:
         if board[x1+1][y1-1][0] == "w":
            potential_moves.append([x1+1], [y1-1])
     except IndexError:
         pass
                    
 #resolve knight moves. 8 possible moves maximally
     if board[x1][y1] == "blackn1":

        potential_moves.append([[x1+2], [y1+1]])
        potential_moves.append([[x1+2], [y1-1]])
        potential_moves.append([[x1+1], [y1+2]])
        potential_moves.append([[x1+1], [y1+2]])
        potential_moves.append([[x1-2], [y1-1]])
        potential_moves.append([[x1-2], [y1+1]])
        potential_moves.append([[x1-1], [y1+2]])
        potential_moves.append([[x1-1], [y1-2]])
                  
if board[x1][y1] == "blackb1":

				# down and right
  a = x1 + 1
  b = y1 + 1
  while (7 > a >= 0 and 7 > b >= 0) and (board[a][b] == ""):
      potential_moves.append([[a], [b]])
      try:
          if board[a+1][b+1][0] == "blackb1":
              potential_moves.append([[a+1], [b+1]])
      except IndexError:
        pass
      a += 1
      b += 1

# down and left
a = x1 + 1
b = y1 - 1
while (7 > a >= 0 and 7 > b >= 0) and (board[a][b] == ""):
     potential_moves.append([[a], [b]])
     try:
          if board[a+1][b-1][0] == "w":
             potential_moves.append([[a+1], [b-1]])
     except IndexError:
          pass
a += 1
b -= 1
# up and right

a = x1 - 1
b = y1 + 1
while (7 > a >= 0 and 7 > b >= 0) and (board[a][b] == ""):
     potential_moves.append([[a], [b]])
     try:
         if board[a-1][b+1][0] == "w":
            potential_moves.append([[a-1], [b+1]])
     except IndexError:
         pass
     a -= 1
     b += 1

# up and left
a = x1 - 1
b = y1 - 1
while (7 > a >= 0 and 7 > b >= 0) and (board[a][b] == ""):
            potential_moves.append([[a], [b]])
            try:
                if board[a-1][b-1][0] == "w":
                    potential_moves.append([[a-1], [b-1]])
            except IndexError:
                pass
            a -= 1
            b -= 1
				
turn = 1
display_game(1)

canvas.bind('<Button-1>', move_image)
canvas.bind('<Button-1>', get_position, add="+")
coordinates=Text(root,height=2)
coordinates.pack()

root.mainloop()
