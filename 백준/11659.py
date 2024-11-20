import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums=list(map(int, input().split()))

prefixSum= [0] * (N + 1)
prefixSum[0] = nums[0]
for i in range(1, (N + 1)):
    prefixSum[i] = prefixSum[i-1] + nums[i-1]

for _ in range(M):
    i, j = map(int, input().split())
    print(prefixSum[j] - prefixSum[i-1])