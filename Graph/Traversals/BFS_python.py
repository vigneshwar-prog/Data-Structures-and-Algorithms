def bfs_traverse(start,adj_dict,end):

    global dist, pred
    for i in adj_dict:
        dist[i] = 999999999
        pred[i] = -1
    visited[start] = True
    dist[start] = 0
    queue = []
    queue.append(start)
    while (len(queue) != 0):
        start_node = queue.pop(0)
        for i in adj_dict[start_node]:
            if(visited[i] != True):
                visited[i] = True
                dist[i] = dist[start_node] + 1
                pred[i] = start_node
                queue.append(i)
                if(i == end):
                    return True
    return False    
N, B = map(int,input().strip().split())
adj = {}
dist = {}
pred = {}
visited = {}
for i in range(N):
    bond = input().strip().split()
    if bond[0] not in visited:
        visited[bond[0]] = False
        adj[bond[0]] = []
    adj[bond[0]].append(bond[1])
    if bond[1] not in visited:
        visited[bond[1]] = False
        adj[bond[1]] = []
    adj[bond[1]].append(bond[0])

start,end = input().split()
if(bfs_traverse(start,adj,end)):
    print(dist[end])
else:
    print(-1)


