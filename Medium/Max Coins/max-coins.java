//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG implements Runnable
{
    public static void main(String args[])throws IOException
    {
        new Thread(null, new GFG(), "whatever", 1<<26).start();
    }
    public void run()
    {
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t=Integer.parseInt(in.readLine());
            while(t-->0){
                int n=Integer.parseInt(in.readLine().trim());
                int a[][]=new int[n][3];
                for(int i=0;i<n;i++){
                    String s[]=in.readLine().trim().split(" ");
                    a[i][0]=Integer.parseInt(s[0]);
                    a[i][1]=Integer.parseInt(s[1]);
                    a[i][2]=Integer.parseInt(s[2]);
                }
                Solution ob=new Solution();
                out.println(ob.maxCoins(n,a));
            }
            out.close();
        }catch(Exception e){
            ;
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int helper(int idx,int dp[][],int rem,int ranges[][])
    {
        if(idx>=ranges.length)
            return 0;
        if(rem==0) return 0;
        if(dp[idx][rem]!=-1) return dp[idx][rem];
        int notTake=helper(idx+1,dp,rem,ranges);
        int take=ranges[idx][2];
        int newIdx=(int)(1e9),l=idx+1,h=ranges.length-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(ranges[mid][0]>=ranges[idx][1])
            {
               newIdx=mid;
               h=mid-1;
            }
            else l=mid+1;
        }
        take+=helper(newIdx,dp,rem-1,ranges);
        return dp[idx][rem]=Math.max(take,notTake);
    }
    public static int maxCoins(int n,int ranges[][])
    {
        Arrays.sort(ranges,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int dp[][]=new int[n+1][3];
        for(int i=0;i<=n;i++)
        Arrays.fill(dp[i],-1);
        return helper(0,dp,2,ranges);
    }
}