import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def DFS(x, y):
    dx = [1, 0, 0, -1]
    dy = [0, 1, -1, 0]

    matrix[x][y] = -1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < N and 0 <= ny < M and matrix[nx][ny] == 1:
            DFS(nx, ny)


T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split())
    matrix = [[0] * M for _ in range(N)]  

    for _ in range(K):
        X, Y = map(int, input().split())
        matrix[Y][X] = 1

    count = 0
    for x in range(N):
        for y in range(M):
            if matrix[x][y] == 1:
                DFS(x, y)
                count+=1

    print(count)    