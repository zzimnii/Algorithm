from collections import Counter

def solution(k, tangerine):
    answer = 0  # 종류
    total = 0 # 총 개수
    cnt = Counter(tangerine).most_common()
    print(cnt)
    for size, count in cnt:
        total += count
        answer += 1
        if total >= k:
            return answer

print(solution(6, [1, 3, 2, 5, 4, 5, 2, 3]))
print(solution(4, [1, 3, 2, 5, 4, 5, 2, 3]))
print(solution(2, [1, 1, 1, 1, 2, 2, 2, 3]))