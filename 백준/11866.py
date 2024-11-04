from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().strip().split())
q = deque(range(1, n+1))
result = []

while q:
    for i in range(0,k-1):
        q.append(q.popleft())
    result.append(str(q.popleft()))

print("<"+', '.join(result)+'>')