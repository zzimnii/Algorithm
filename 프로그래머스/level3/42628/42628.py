from collections import deque

def solution(operations):
    answer = []

    for i in range(len(operations)):
        if operations[i].startswith("I "):
            operations[i] = operations[i].split(" ")
            answer.append(int(operations[i][1]))
        elif answer:
            if operations[i] == "D -1":
                answer.remove(min(answer))
            elif operations[i] == "D 1":
                answer.remove(max(answer))
    if not answer:
        return [0, 0]
    return [max(answer), min(answer)]

print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))
print(solution(["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))