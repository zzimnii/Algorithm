import sys
input = sys.stdin.readline

n = int(input())

for _ in range(n):
    count = 0
    A, B, N = list(map(int, input().split()))

    a, b = min(A, B), max(A, B)
    
    # N을 초과할 때까지 a와 b를 번갈아 더하는 연산 수행
    while max(a, b) <= N:
        a, b = b, a + b
        count += 1
    
    print(count)