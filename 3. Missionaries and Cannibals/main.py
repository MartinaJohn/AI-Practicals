from collections import deque

def bfs(start, goal, queue):
    if start == goal:
        return [start]

    visited = set()
    visited.add(start)

    while queue:
        current = queue.popleft()
        m, c, boat = current
        for (new_m, new_c) in [(m - 2, c), (m - 1, c - 1), (m - 1, c), (m, c - 2), (m, c - 1), (m + 1, c + 1), (m + 2, c), (m + 1, c)]:
            if new_m >= 0 and new_m <= 3 and new_c >= 0 and new_c <= 3 and new_c <= new_m:
                next_state = (new_m, new_c, 1 - boat)
                if next_state not in visited:
                    visited.add(next_state)
                    if next_state == goal:
                        return [current, next_state]
                    queue.append(next_state)

    return None

def main():
    start = (3, 3, 0)
    goal = (0, 0, 1)
    queue = deque([start])
    result = bfs(start, goal, queue)

    if result:
        for state in result:
            print(state)
    else:
        print("No solution found")
    
if __name__ == '__main__':
    main()