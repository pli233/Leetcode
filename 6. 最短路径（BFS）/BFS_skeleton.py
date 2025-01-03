# 从 s 开始 BFS 遍历图的所有节点，且记录遍历的步数
from collections import deque


def bfs(graph, s):
    visited = [False] * len(graph)
    q = deque([s])
    visited[s] = True
    # 记录从 s 开始走到当前节点的步数
    step = 0
    
    while q:
        sz = len(q)
        for i in range(sz):
            cur = q.popleft()
            print(f"visit {cur} at step {step}")
            # 判断是否到达终点
            if cur == target:
                return step

            # 将邻居节点加入队列，向四周扩散搜索
            for to in neighborsOf(cur):
                if not visited[to]:
                    q.append(to)
                    visited[to] = True
        step += 1
    # 如果走到这里，说明在图中没有找到目标节点
    return -1


def bfs(graph, s, target):
    # 如果起点就是终点
    if s == target:
        return 0

    # 初始化访问数组
    visited = [False] * len(graph)
    visited[s] = True
    
    # 初始化队列stack
    q = deque([])  
    q.append(s)
    step = 0
    
    while q:
        sz = len(q)
        
        # 遍历当前层
        for i in range(sz):
            cur = q.popleft()
            
            # 判断是否到达目标节点
            if cur == target:
                return step
            
            # 遍历当前节点的邻居
            for neighbor in graph[cur]:  # 假设 graph 是邻接列表
                if not visited[neighbor]:
                    visited[neighbor] = True  # 标记访问
                    q.append(neighbor)
        
        step += 1  # 当前层结束，步数增加
    
    # 如果遍历完整个图都找不到目标节点
    return -1

            
    
    
    