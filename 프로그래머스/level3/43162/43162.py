def solution(n, computers):
    answer = 0

    def DFS(node, visited):
        visited[node] = True

        for i in range(n):
            if computers[node][i] == 1 and not visited[i]:
                DFS(i, visited)

    visited = [False] * n

    for i in range(n):
        if not visited[i]:
            DFS(i, visited)
            answer += 1
    return answer

print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))