import numpy as np

grid = [[2,0,0,3,0,0,0,0,0],
        [8,0,4,0,6,2,0,0,3],
        [0,1,3,8,0,0,2,0,0],
        [0,0,0,0,2,0,3,9,0],
        [5,0,7,0,0,0,6,2,1],
        [0,3,2,0,0,6,0,0,0],
        [0,2,0,0,0,9,1,4,0],
        [6,0,1,2,5,0,8,0,9],
        [0,0,0,0,0,1,0,0,2]]

def possible(y,x,num):
    global grid
    #row check
    for i in range(0,9):
        if grid[y][i] == num:
            return False
    #col check
    for i in range(0,9):
        if grid[i][x] == num:
            return False 
        
    #block check 
    
    x0 = (x//3)*3
    y0 = (y//3)*3
    
    for i in range(y0,y0+3):
        for j in range(x0,x0+3):
            if grid[i][j] == num:
                return False
    return True

def solveSudoku():
    global grid
    for y in range(9):
        for x in range(9):
            if grid[y][x] == 0:
                for n in range(1,10):
                    if possible(y,x,n):
                        grid[y][x] = n 
                        solveSudoku()
                        grid[y][x] = 0
                return 
    print(np.matrix(grid))
    input("More?")

solveSudoku()