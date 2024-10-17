def solution(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1

    m = [0] * (n + 1)
    m[1] = 1
    
    # 피보나치를 반복문으로 수행하여 수행 시간을 줄임
    for i in range(2, n + 1):
        m[i] = (m[i - 1] + m[i - 2]) % 1234567
    
    return m[n]