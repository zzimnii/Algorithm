import math

def solution(arr):
    answer = arr[0]
    
    for n in arr[1:]:
        answer = lcm(answer, n)
    
    return answer

def lcm(n,m):
    return n*m//math.gcd(n,m)

print(solution([2,6,8,14]))
print(solution([1,2,3]))