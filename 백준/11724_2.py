import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def DFS(graph, n, visited):
    visited[n] = True

    for i in graph[n]:
        if visited[i] == False:
            DFS(graph, i, visited)

N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    
count = 0
visited=[False for _ in range(N+1)]

for i in range(1, N+1):
    if not visited[i]:
        DFS(graph, i, visited)
        count += 1
    
print(count)