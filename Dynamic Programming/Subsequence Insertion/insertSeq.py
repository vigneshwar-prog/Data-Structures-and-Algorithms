string1 = input().strip()
string2 = input().strip()
len1 = len(string1)
len2 = len(string2)
mat = [[0 for j in range(len2+1)] for i in range(len1+1)]
for i in range(1,len1+1):
    for j in range(1,len2+1):
        if(string1[i-1] == string2[j-1]):
            mat[i][j] = 1 + mat[i-1][j-1]
        else:
            mat[i][j] = max(mat[i-1][j], mat[i][j-1])
length = mat[len1][len2]
print(len1 - length)