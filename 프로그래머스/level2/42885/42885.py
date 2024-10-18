def solution(people, limit):
    answer = 0
    people = sorted(people, reverse=True)
    # 투포인터
    left ,right = 0, len(people)-1

    # 0 1 2
    # -1 -2 -3
    while left <= right:
        if people[left] + people[right] <= limit:
            right -= 1
        
        answer += 1
        left += 1

    return answer

print(solution([70, 50, 80, 50], 100))
print(solution([20,20,20], 100))