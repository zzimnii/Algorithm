import sys
input = sys.stdin.readline

H = 0
N, M = map(int, input().split())
tree = list(map(int, input().split()))

low = 0
high = max(tree)

while low <= high:
    total = 0
    mid = (low+high)//2

    for t in tree:
        if t > mid:
            total = total + (t - mid)
    
    if total >= M:
        low = mid + 1
        H = mid
    else:
        high = mid - 1

print(H)