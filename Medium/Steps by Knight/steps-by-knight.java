//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class tuple
{
    int row;
    int col;
    int count;
    tuple(int row,int col,int count)
    {
        this.row=row;
        this.col=col;
        this.count=count;
    }
}
class Solution
{
    boolean valid(int i,int j,int n)
    {
        return i>=0 && i<=n && j>=0 && j<=n;
    }
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int x[], int y[], int n)
    {
        // Code here
        Queue<tuple> q=new LinkedList<>();
        q.offer(new tuple(x[0],x[1],0));
        boolean visited[][]=new boolean[n+1][n+1];
        visited[x[0]][x[1]]=true;
        while(!q.isEmpty())
        {
            tuple top=q.poll();
            int i=top.row;
            int j=top.col;
            int count=top.count;
            //base case\
            if(y[0]==i && y[1]==j) return count;
            
            if(valid(i+1,j+2,n) && !visited[i+1][j+2])
            {
                q.offer(new tuple(i+1,j+2,count+1));
                visited[i+1][j+2]=true;
            }
            if(valid(i+1,j-2,n) && !visited[i+1][j-2])
            {
                q.offer(new tuple(i+1,j-2,count+1));
                visited[i+1][j-2]=true;
            }
            
            if(valid(i-1,j+2,n) && !visited[i-1][j+2])
            {
                q.offer(new tuple(i-1,j+2,count+1));
                visited[i-1][j+2]=true;
            }
            if(valid(i-1,j-2,n) && !visited[i-1][j-2])
            {
                q.offer(new tuple(i-1,j-2,count+1));
                visited[i-1][j-2]=true;
            }
            
            if(valid(i+2,j+1,n) && !visited[i+2][j+1])
            {
                q.offer(new tuple(i+2,j+1,count+1));
                visited[i+2][j+1]=true;
            }
            if(valid(i+2,j-1,n) && !visited[i+2][j-1])
            {
                q.offer(new tuple(i+2,j-1,count+1));
                visited[i+2][j-1]=true;
            }
            if(valid(i-2,j+1,n) && !visited[i-2][j+1])
            {
                q.offer(new tuple(i-2,j+1,count+1));
                visited[i-2][j+1]=true;
            }
            if(valid(i-2,j-1,n) && !visited[i-2][j-1])
            {
                q.offer(new tuple(i-2,j-1,count+1));
                visited[i-2][j-1]=true;
            }
        }
        return -1;
    }
}