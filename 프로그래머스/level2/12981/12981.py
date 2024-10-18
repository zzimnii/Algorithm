# set을 활용해서 효율적으로 구현
def solution(n, words):
    words_set = set()
    words_set.add(words[0])

    for i in range(1, len(words)):
        if words[i-1][-1] != words[i][0] or words[i] in words_set:
            return [i%n+1, i//n+1]
        words_set.add(words[i])
            
    return [0, 0]

# 리스트 활용
def solution(n, words):
    answer = [0, 0]
    arr = []
    arr.append(words[0])

    for i in range(1, len(words)):
        if arr[-1][-1] == words[i][0]:
            if words[i] not in arr:
                arr.append(words[i])
            # 말한 단어 또 말한 경우
            else:
                answer[0] = i%n+1
                answer[1] = i//n+1
                break

        # 끝말잇기 실패
        else:
            answer[0] = i%n+1
            answer[1] = i//n+1
            break
            
    return answer


print(solution(3, ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]))
print(solution(5, ["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]))
print(solution(2, ["hello", "one", "even", "never", "now", "world", "draw"]))