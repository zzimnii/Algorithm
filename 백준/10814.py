members = []
n = int(input())

for _ in range(n):
    age, name = input().split()
    members.append((int(age), name))

members.sort(key=lambda x:(x[0]))
for age, name in members:
    print(age, name)