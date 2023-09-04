//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static boolean valid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    static void bfs(int i, int j, char temp[][], char a[][], boolean visited[][]) {
        int m = a.length, n = a[0].length;
        if (!valid(i, j, m, n) || visited[i][j] || a[i][j] == 'X') {
            return;
        }
        visited[i][j] = true;
        temp[i][j] = 'O';
        bfs(i + 1, j, temp, a, visited);
        bfs(i - 1, j, temp, a, visited);
        bfs(i, j + 1, temp, a, visited);
        bfs(i, j - 1, temp, a, visited);
    }

    static char[][] fill(int m, int n, char a[][]) {
        boolean visited[][] = new boolean[m][n];
        char[][] temp = new char[m][n];
        for (char ch[] : temp) {
            Arrays.fill(ch, '.');
        }

        int i, j;
        for (i = 0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && a[i][j] == 'O') {
                    bfs(i, j, temp, a, visited);
                }
            }
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (temp[i][j] == '.') {
                    a[i][j] = 'X';
                } else {
                    a[i][j] = 'O';
                }
            }
        }
        return a;
    }
}
