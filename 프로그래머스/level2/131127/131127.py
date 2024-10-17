def solution(want, number, discount):
    answer = 0
    want_dict = {}

    # 필요한 물품과 개수를 dictionary로 
    for i, j in zip(want, number):
        want_dict[i] = j
        
    for i in range(len(discount) - 9):
        # 딕셔너리 복사해서 수정용으로 사용 (원본 유지)
        temp_dict = want_dict.copy()

        # 해당 10일간의 제품을 확인하며 수량 감소
        for d in discount[i:i+10]:
            if d in temp_dict:
                temp_dict[d] -= 1  # 구매한 수량 감소

        # 모든 제품의 요구 수량을 만족하면 answer 증가
        result = True
        for d in temp_dict.keys():
            if temp_dict[d] != 0:
                result = False
        if result:
            answer += 1
        
    return answer

print(solution(["banana", "apple", "rice", "pork", "pot"], [3, 2, 2, 2, 1], ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]))