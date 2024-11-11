# import sys
# sys.stdin = open("input.txt", "r")
from collections import Counter

T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    n_list = list(map(int, input().split()))
    c = Counter(n_list)
    c = sorted(c.items(), key=lambda x: (-x[1], -x[0]))
    most_common_value = c[0][0]
    print("#",n, " " ,most_common_value)