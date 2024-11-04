import sys
input = sys.stdin.readline
stack = []
result = []
n = int(input())

for _ in range(n):
    arr = input().split()
    if arr[0] == 'push':
        stack.append(int(arr[1]))
    elif arr[0] == 'top':
        if len(stack) != 0:
            result.append(str(stack[-1]))
        else:
            result.append('-1')
    elif arr[0] == 'size':
        result.append(str(len(stack)))
    elif arr[0] == 'empty':
        if len(stack) == 0:
            result.append('1')
        else:
            result.append('0')
    elif arr[0] == 'pop':
        if len(stack) != 0:
            result.append(str(stack.pop()))
        else:
            result.append('-1')
            
print('\n'.join(result))