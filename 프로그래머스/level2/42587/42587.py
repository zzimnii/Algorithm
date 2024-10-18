from collections import deque

def solution(priorities, location):
    answer = 0
    q = deque(priorities)

    while q:
        m = max(q)
        p = q.popleft()
        location -= 1

        if m != p:
            q.append(p)
            if location < 0:
                location = len(q) -1
        else: 
            answer += 1
            if location < 0:
                break

    return answer
         

print(solution([2, 1, 3, 2], 2))
print(solution([1, 1, 9, 1, 1, 1], 0))