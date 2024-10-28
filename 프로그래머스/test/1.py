def solution(A, B):
    n = len(A)  # 지문 개수
    min_length = 1  # 접두사의 최소 길이

    while True:
        # 접두사와 B 값을 매칭할 딕셔너리
        prefix_map = {}

        # 모든 지문에 대해 현재 길이의 접두사 추출
        for i in range(n):
            prefix = A[i][:min_length]  # 접두사 추출

            # 이미 같은 접두사가 다른 B 값과 매칭된 경우
            if prefix in prefix_map and prefix_map[prefix] != B[i]:
                break  # 더 긴 접두사를 확인해야 함
            prefix_map[prefix] = B[i]  # 접두사와 B 매칭 저장
        else:
            # 중복 없이 매칭이 모두 끝났다면 최소 길이를 반환
            return min_length

        # 매칭이 충돌했으므로 접두사 길이를 늘림
        min_length += 1

# 테스트 실행
A = ['abcdef?', 'bbab?', 'bbabab?', 'abcd?', 'cacsdc?', 'cacabc?', 'cacsz?']
B = [2, 3, 1, 2, 4, 5, 4]
print(solution(A, B))  # 25