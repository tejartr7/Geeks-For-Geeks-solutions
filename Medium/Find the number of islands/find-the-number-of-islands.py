#User function Template for python3

import sys
from collections import deque

sys.setrecursionlimit(10**8)

class Solution:
    def bfs(self, i, j, v, grid):
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1), (-1, 1), (1, -1), (1, 1), (-1, -1)]
        v[i][j] = 1
        q = deque([(i, j)])
        while q:
            a, b = q.popleft()
            for dx, dy in directions:
                x, y = a + dx, b + dy
                if 0 <= x < len(grid) and 0 <= y < len(grid[0]) and grid[x][y] == 1 and not v[x][y]:
                    v[x][y] = 1
                    q.append((x, y))

    def numIslands(self, grid):
        n = len(grid)
        m = len(grid[0])
        cnt = 0
        v = [[0 for _ in range(m)] for _ in range(n)]
        for i in range(n):
            for j in range(m):
                if not v[i][j] and grid[i][j] == 1:
                    cnt += 1
                    self.bfs(i, j, v, grid)
        return cnt


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__=="__main__":
    for _ in range(int(input())):
        n,m=map(int,input().strip().split())
        grid=[]
        for i in range(n):
            grid.append([int(i) for i in input().strip().split()])
        obj=Solution()
        print(obj.numIslands(grid))
# } Driver Code Ends