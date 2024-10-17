def solution(s):
    answer = -1
    stack = []

    for c in s:

        if stack and stack[-1] == c:
            stack.pop()
        else:
            stack.append(c)
    
    if stack:
        return 0
    else:
        return 1

print(solution("baabaa"))
print(solution("cdcd"))