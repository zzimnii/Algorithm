import sys
input = sys.stdin.readline

answer = 0
n = int(input())

people = list(map(int,input().split()))
people.sort()

for i in range(n):
    answer = answer +  people[i]*(n-i)

print(answer)
