def solution(n):
    answer = 0
    
    # bin() 으로 2진수로 변환!!!
    count_ones = bin(n).count('1')

    while True:
        n += 1
        if bin(n).count('1') == count_ones:
            return n

print(solution(78))
print(solution(15))