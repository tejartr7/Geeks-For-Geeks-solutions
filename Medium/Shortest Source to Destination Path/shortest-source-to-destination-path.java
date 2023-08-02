//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class tuple
{
    int x;
    int y;
    int lvl;
    tuple(int a,int b,int c)
    {
        x=a;
        y=b;
        lvl=c;
    }
}

class Solution {
    boolean valid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    int shortestDistance(int m, int n, int a[][], int x, int y) {
        // code here
        Queue<tuple> q=new LinkedList<>();
        if(a[0][0]==0)
        return -1;
        q.offer(new tuple(0,0,0));
        boolean visited[][]=new boolean[m][n];
        while(!q.isEmpty())
        {
            tuple top=q.poll();
            int r=top.x;
            int c=top.y;
            int lvl=top.lvl;
            visited[r][c]=true;
            if(r==x && c==y)
            return lvl;
            if(valid(r+1,c,m,n) && !visited[r+1][c] && a[r+1][c]==1)
            {
                q.offer(new tuple(r+1,c,lvl+1));
                visited[r+1][c]=true;
            }
            if(valid(r-1,c,m,n) && !visited[r-1][c] && a[r-1][c]==1)
            {
                q.offer(new tuple(r-1,c,lvl+1));
                visited[r-1][c]=true;
            }
            if(valid(r,c+1,m,n) && !visited[r][c+1] && a[r][c+1]==1)
            {
                q.offer(new tuple(r,c+1,lvl+1));
                visited[r][c+1]=true;
            }
            if(valid(r,c-1,m,n) && !visited[r][c-1] && a[r][c-1]==1)
            {
                q.offer(new tuple(r,c-1,lvl+1));
                visited[r][c-1]=true;
            }
        }
        return -1;
    }
};