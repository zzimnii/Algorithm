import sys
from collections import Counter
input = sys.stdin.readline
people = []
result = []
N, M = map(int, input().split())

for i in range(N+M):
    people.append(input().strip())

people.sort()
cnt = Counter(people)
for item, count in cnt.items():
    if count >= 2:
        result.append(item)

print(len(result))
for r in result:
    print(r)