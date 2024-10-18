def solution(routes):
    answer = 0
    routes = sorted(routes, key=lambda x : x[1])    # 진출 위치 기준으로 정렬
    exit = -30001

    for route in routes:
        if route[0] > exit: # 진출 위치보다 크면 갱신
            answer += 1
            exit = route[1]

    return answer

print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]]))