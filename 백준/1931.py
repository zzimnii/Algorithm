import sys
input = sys.stdin.readline

N = int(input())

times = [list(map(int, input().split())) for _ in range(N)]

# 회의가 끝나는 시간 순서로 정렬
times.sort(key=lambda x:(x[1], x[0]))

end_time = 0
count = 0
for start, end in times:
    if start >= end_time:
        end_time = end
        count += 1

print(count)