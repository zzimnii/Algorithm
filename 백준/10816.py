n = int(input())
n_list = list(map(int, input().split()))
m = int(input())
m_list = list(map(int, input().split()))
dic = {}

for n_num in n_list:
    if n_num in dic:
        dic[n_num] += 1
    else:
        dic[n_num] = 1
        
result = []
for m_num in m_list:
    if m_num in dic:
        result.append(str(dic[m_num]))
    else:
        result.append('0')
        
print(' '.join(result))