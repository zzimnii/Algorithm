n = int(input())
nums1 = set(map(int,input().split()))
m = int(input())
nums2 = list(map(int,input().split()))

result = []
for num in nums2:
    if num in nums1:
        result.append("1")
    else:
        result.append("0")
print("\n".join(result))