from itertools import combinations

answer = 0
n, m = list(map(int, input().split()))
nums=list(map(int, input().split()))

com = list(combinations(nums, 3))
for c in com:
    if sum(c) <= m:
        answer = max(answer, sum(c))
print(answer)