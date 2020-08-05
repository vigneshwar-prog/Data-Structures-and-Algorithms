import heapq

lt = list(map(int,input().split()))
k = int(input())
heapq.heapify(lt)
for i in range(k):
    print(lt.pop(0),end=" ")
    heapq.heapify(lt)
