//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dp[];
    static boolean isHappy(int i)
    {
        int x=i;
        int sum=0;
        if(i==1 || i==7) return true;
        if(i<10) return false;
        if(dp[i]!=-1) return dp[i]==1;
        while(x>0)
        {
            int k=x%10;
            sum+=(k*k);
            x/=10;
        }
        //System.out.println(sum);
        if(sum==1 || sum==7) { dp[i]=1; return true;}
        if(sum==i) { dp[i]=0;return false;}
        return isHappy(sum);
    }
    static int nextHappy(int n){
        // code here
        dp=new int[100001];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        int i;
        //System.out.println(isHappy(9));
        for(i=n+1;i<=100000;i++)
        {
            if(isHappy(i)) return i;
            
        }
        return -1;
    }
}