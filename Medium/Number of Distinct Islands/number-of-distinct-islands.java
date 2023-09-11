//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean valid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    void dfs(int i, int j, int m, int n, int[][] grid, StringBuilder island) {
        if (!valid(i, j, m, n) || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = -1; // Mark the cell as visited

        // Explore in all four directions (down, up, right, left)
        dfs(i + 1, j, m, n, grid, island.append('d'));
        dfs(i - 1, j, m, n, grid, island.append('u'));
        dfs(i, j + 1, m, n, grid, island.append('r'));
        dfs(i, j - 1, m, n, grid, island.append('l'));
    }

    int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder island = new StringBuilder("c");
                    dfs(i, j, m, n, grid, island);
                    set.add(island.toString());
                }
            }
        }

        return set.size();
    }
}

