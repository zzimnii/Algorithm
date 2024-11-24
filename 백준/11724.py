import sys
from collections import deque
input = sys.stdin.readline

def BFS(graph, n, visited):
    q = deque([n])
    visited[n] = True

    while q:
        n = q.popleft()
        for i in graph[n]:
            if not visited[i]:
                q.append(i)
                visited[i] = True


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
        BFS(graph, i, visited)
        count += 1
    
print(count)