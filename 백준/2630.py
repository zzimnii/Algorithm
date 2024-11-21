import sys
input = sys.stdin.readline

def div(y, x, N):
    color = paper[y][x]
    for i in range(y, y+N):
        for j in range(x, x+N):
            if color != paper[i][j]:
                div(y, x, N//2)
                div(y, x + N//2, N//2)
                div(y + N//2, x, N//2)
                div(y + N//2, x + N//2, N//2)
                return
            
    if color == 0:
        result[0] += 1
    else:
        result[1] += 1

N = int(input())

paper = [list(map(int, input().split())) for _ in range(N)]
result = [0, 0]
div(0, 0, N)
print(result[0])
print(result[1])