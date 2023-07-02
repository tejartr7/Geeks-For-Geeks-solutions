//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static boolean valid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    public static void dfs(int i,int j,String s,List<String> list,boolean vis[][],int grid[][])
    {
        int m=grid.length,n=grid[0].length;
        if(!valid(i,j,m,n) || vis[i][j] || grid[i][j]==0) 
        return ;
        if(i==m-1 && j==n-1) 
        {list.add(s);
        return ;
        }
        vis[i][j]=true;
        dfs(i+1,j,s+"D",list,vis,grid);
        dfs(i-1,j,s+"U",list,vis,grid);
        dfs(i,j+1,s+"R",list,vis,grid);
        dfs(i,j-1,s+"L",list,vis,grid);
        vis[i][j]=false;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> list=new ArrayList<>();
        boolean vis[][]=new boolean[n][n];
        dfs(0,0,"",list,vis,m);
        return list;
    }
}