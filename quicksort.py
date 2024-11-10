import random
import time

def quick_sort(arr, p, r):
    if p < r:
        q = partition(arr, p, r)
        quick_sort(arr, p, q)
        quick_sort(arr, q + 1, r)

def partition(arr, p, r):
    x = arr[p]
    i = p - 1
    j = r + 1

    while True:
        while True:
            i += 1
            if i >= r or arr[i] >= x:
                break
        while True:
            j -= 1
            if j <= p or arr[j] <= x:
                break

        if i < j:
            arr[i], arr[j] = arr[j], arr[i]
        else:
            return j

n_values = [17, 33, 65, 129, 257, 513]
m_values = [10000, 100000, 200000, 400000, 800000, 1600000, 3200000, 6400000]

for m in m_values:
    arr1 = [random.randint(0, 999999999) for _ in range(m)]
    print(f"quicksort = ", m, end="")

    start_time = time.time() * 1000  # 밀리초 단위로 변환
    quick_sort(arr1, 0, len(arr1) - 1)
    end_time = time.time() * 1000