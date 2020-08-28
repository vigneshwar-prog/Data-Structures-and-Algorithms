def printULayers(row,col,r,c,layer):
    global mat
    if(row < r-layer and row>=0 and col< c-layer and col>=0 and mat[row][col] != "&&&" and 
    (row == r - layer-1 or col == layer or col == c-layer-1)):
        print(mat[row][col],end=" ")
        mat[row][col] = "&&&"
        printULayers(row+1,col,r,c,layer)
        printULayers(row,col+1,r,c,layer)
        printULayers(row-1,col,r,c,layer)       
        

n = int(input())
mat = []
visited =[[False for i in range(n)] for j in range(n)]
for i in range(n):
    mat.append(list(map(int,input().split())))
for i in range(n//2):
    printULayers(0,i,n,n,i)
    print()