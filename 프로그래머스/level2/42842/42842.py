def solution(brown, yellow):
    answer = [0]*2

    y_x = y_y = b_x = b_y = 0

    for i in range(1,yellow+1):
        # yellow // i 하면 yellow의 세로, i는 가로
        if yellow % i == 0:
            y_y = yellow // i
            y_x = i
            b_x = i + 2
            b_y = y_y + 2
            # brown // (i+2) 하면 brown의 세로, i+2는 가로
            if (brown+yellow) % (b_x) == 0:
                # if (yellow // i) == ((brown+yellow) // (i+2))+2:
                answer[0] = b_x
                answer[1] = b_y

    return answer

print(solution(10,2))
print(solution(8,1))
print(solution(24,24))