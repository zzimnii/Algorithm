import sys
from collections import deque
input = sys.stdin.readline

computers = int(input())
n = int(input())
graph = [[] for _ in range(computers+1)]
visited = [False for _ in range(computers+1)]

def BFS(x):
    count = 0
    q = deque([x])
    visited[x] = True

    while q:
        n = q.popleft()
        for next in graph[n]:
            if not visited[next]:
                visited[next] = True
                count += 1
                q.append(next)

    return count

for _ in range(n):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

print(BFS(1))