# count = []
# matrix = []
# n, m = list(map(int, input().split()))

# for i in range(n):
#     matrix.append(input())
# https://www.acmicpc.net/problem/1018
# 다시 풀어보기
# for i in range(n-7):
#     for j in range(m-7):
#         w_count = 0
#         b_count = 0
#         for k in range(i, i+8):
#             for l in range(j, j+8):
#                 if (k+l) % 2 == 0:
#                     if matrix[k][l] != 'W':
#                         w_count += 1
#                     if matrix[k][l] != 'B':
#                         b_count += 1
#                 else:
#                     if matrix[k][l] != 'B':
#                         w_count += 1
#                     if matrix[k][l] != 'W':
#                         b_count += 1      
#         count.append(min(b_count, w_count))
    
# print(min(count))