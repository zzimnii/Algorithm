n = int(input())

for _ in range(n):
    stack = []
    flag = True
    vps = input()
    for v in vps:
        if v == '(':
            stack.append(v)
        else:
            if not stack:
                flag = False
                break
            elif stack[-1] == '(':
                stack.pop()
            else:
                print(v)
    if stack or flag==False:
        print("NO")
    else:
        print("YES")