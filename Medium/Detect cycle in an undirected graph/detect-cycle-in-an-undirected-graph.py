from typing import List
from collections import deque

class Solution:
    def isCycle(self, V: int, adj: List[List[int]]) -> bool:
        # Code here
        def hasCycle(node, parent):
            visited[node] = True
            for neighbor in adj[node]:
                if not visited[neighbor]:
                    if hasCycle(neighbor, node):
                        return True
                elif neighbor != parent:
                    return True
            return False

        visited = [False] * V

        for i in range(V):
            if not visited[i]:
                if hasCycle(i, -1):
                    return True

        return False

#{ 
 # Driver Code Starts

if __name__ == '__main__':

	T=int(input())
	for i in range(T):
		V, E = map(int, input().split())
		adj = [[] for i in range(V)]
		for _ in range(E):
			u, v = map(int, input().split())
			adj[u].append(v)
			adj[v].append(u)
		obj = Solution()
		ans = obj.isCycle(V, adj)
		if(ans):
			print("1")
		else:
			print("0")

# } Driver Code Ends