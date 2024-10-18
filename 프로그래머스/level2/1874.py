n = int(input())
input_stack = []
stack = []
op = []

for i in range(n):
    input_stack.append(int(input()))

current = 1
for num in input_stack:
    while current <= num:
        stack.append(current)
        op.append('+')
        current += 1

    if stack[-1] == num:
        op.append('-')
        stack.pop()
    else:
        print("NO")
        exit()  
        
print("\n".join(op))