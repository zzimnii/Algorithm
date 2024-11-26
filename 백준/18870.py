import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
numSet = sorted(set(nums))

dic = {}
for i in range(len(numSet)):
    dic[numSet[i]] = i
    
for n in nums:
    print(dic[n], end=' ')