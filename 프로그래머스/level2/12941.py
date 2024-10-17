

def solution(A,B):
    answer = 0

    A = sorted(A)
    B = sorted(B, reverse=True)
    n = len(A)

    for i in range(n):
        t = A[i]*B[i]
        answer = answer + t

    return answer

solution([1,4,2], [5,4,4])