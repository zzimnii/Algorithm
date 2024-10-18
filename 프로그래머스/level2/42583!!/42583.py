from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = deque([0]*bridge_length)
    bridge_weight = 0
    trucks = deque(truck_weights)

    while bridge:
        answer += 1

        bridge_weight -= bridge.popleft()

        if trucks:
            if bridge_weight + trucks[0] <= weight:
                bridge_weight += trucks[0]
                bridge.append(trucks[0])
                trucks.popleft()
            else:
                bridge.append(0)
    
    return answer

print(solution(2, 10, [7,4,5,6]))
print(solution(100, 100, [10]))
print(solution(100, 100, [10,10,10,10,10,10,10,10,10,10]))