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
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[] = new int[n];
            for (int i = 0; i < n; i++)
                Arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxSumLis(Arr, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair
{
    int sum;
    int cnt;
    pair(int sum,int cnt)
    {
        this.sum=sum;
        this.cnt=cnt;
    }
}
class Solution {
    static int maxSumLis(int arr[], int n) {
        // code here
        //ArrayList<pair> list=new ArrayList<>();
        int sum=0;
        int i,j;
        int dp[]=new int[n];
        int cnt[]=new int[n];
        dp[0]=arr[0];
        Arrays.fill(cnt,1);
        for(int x:arr)
        sum+=x;
        for(i=1;i<n;i++)
        {
            dp[i]=arr[i];
            for(j=i-1;j>=0;j--)
            {
                if(arr[j]<arr[i])
                {
                   if(1+cnt[j]>cnt[i])
                   {
                       cnt[i]=1+cnt[j];
                       dp[i]=dp[j]+arr[i];
                   }
                }
            }
        }
        /*for(i=0;i<n;i++)
        System.out.print(dp[i]+" ");
        System.out.print("\n");
        for(i=0;i<n;i++)
        System.out.print(cnt[i]+" ");
        System.out.print("\n");*/
        int maxi=0;
        int idx=-1;
        for(i=0;i<n;i++)
        {
            if(cnt[i]>maxi)
            {
                maxi=cnt[i];
            }
        }
        int mini=Integer.MAX_VALUE;
        for(i=0;i<n;i++)
        {
            if(cnt[i]==maxi)
            {
                mini=Math.min(mini,dp[i]);
            }
        }
        return sum-mini;
    }
}