from collections import deque
import sys
input = sys.stdin.readline

result = []
q = deque()
n = int(input())

for _ in range(n):
    arr = input().strip().split()
    if arr[0] == 'push':
        q.append(arr[1])
    elif arr[0] == 'pop':
        if len(q) == 0:
            result.append('-1')
        else:
            result.append(str(q.popleft()))
    elif arr[0] == 'size':
        result.append(str(len(q)))
    elif arr[0] == "empty":
        if len(q) == 0:
            result.append('1')
        else:
            result.append('0')
    elif arr[0] == 'front':
        if len(q) != 0:
            result.append(str(q[0]))
        else:
            result.append('-1')
    elif arr[0] == 'back':
        if len(q) != 0:
            result.append(str(q[-1]))
        else:
            result.append('-1')

print('\n'.join(result))