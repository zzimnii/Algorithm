def solution(sizes):
    sizes.sort()
    
    for i in range(len(sizes)):
        if sizes[i][0] < sizes[i][1]:
            tmp = sizes[i][0]
            sizes[i][0] = sizes[i][1]
            sizes[i][1] = tmp
    
    max_x = max(size[0] for size in sizes)
    max_y = max(size[1] for size in sizes)

    return max_x * max_y

def solution(sizes):
    # 각 명함을 회전해서 큰 값을 [0]에 배치
    for size in sizes:
        size.sort(reverse=True)

    # 최대 가로 길이와 최대 세로 길이를 찾음
    max_width = max(size[0] for size in sizes)
    max_height = max(size[1] for size in sizes)

    # 지갑의 최소 크기 계산
    return max_width * max_height

print(solution([[60, 50], [30, 70], [60, 30], [80, 40]]))
print(solution([[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]))
print(solution([[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]))