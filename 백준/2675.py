n = int(input())
num = []
ss = []
for i in range(n):
    a, b = input().split(' ')
    num.append(int(a))
    ss.append(b)

for i in range(n):
    for k in range(0, len(ss[i])):
        for j in range(0, num[i]):
            print(ss[i][k], end='') 
        print(end='')
    print('')