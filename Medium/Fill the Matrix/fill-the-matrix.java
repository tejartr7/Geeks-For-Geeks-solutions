//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class pair{
    int row;
    int col;
    pair(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}
class Solution
{
    public static boolean valid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
	public static int minIteration(int m, int n, int x, int y){
		//code here
		int count=0;
		int arr[][]=new int[m][n];
		int i,j;
		for(i=0;i<m;i++)
		Arrays.fill(arr[i],0);
		Queue<pair> q=new LinkedList<>();
		x--;
		y--;
		q.offer(new pair(x,y));
		while(!q.isEmpty())
		{
		    count++;
		    int l=q.size();
		    for(int k=0;k<l;k++){
		        pair top=q.poll();
		        i=top.row;
		        j=top.col;
		        arr[i][j]=1;
		        if(valid(i+1,j,m,n) && arr[i+1][j]==0)
		        {
		            q.offer(new pair(i+1,j));
		            arr[i+1][j]=1;
		        }
		        if(valid(i-1,j,m,n) && arr[i-1][j]==0)
		        {
		            q.offer(new pair(i-1,j));
		            arr[i-1][j]=1;
		        }
		        if(valid(i,j+1,m,n) && arr[i][j+1]==0)
		        {
		            q.offer(new pair(i,j+1));
		            arr[i][j+1]=1;
		        }
		        if(valid(i,j-1,m,n) && arr[i][j-1]==0)
		        {
		            q.offer(new pair(i,j-1));
		            arr[i][j-1]=1;
		        }
		    }
		}
		return count-1;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends