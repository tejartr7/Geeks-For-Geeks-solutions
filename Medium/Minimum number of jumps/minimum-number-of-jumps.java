//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends




class Solution{
    //static int ans=Integer.MAX_VALUE;
    public static int helper(int nums[],int index,int dp[])
    {
        if(index>=nums.length-1)
            return 0;
        if(nums[index]==0) return 1000_000_000;
        if(dp[index]!=1000_000_000)
            return dp[index];
        int x=nums[index];
       // int k=index;
        int ans=1000_000_000;
        for(int i=1;i<=x;i++)
        {
            int temp=1+helper(nums,index+i,dp);
            ans=Math.min(temp,ans);
        }
        dp[index]=ans;
        return dp[index];
    }
    static int minJumps(int[] nums){
        // your code here
        int ans=0,curr=0,temp=0;
        int i;
        int n=nums.length;
        for(i=0;i<n-1;i++)
        {
            temp=Math.max(temp,nums[i]+i);
            if(i==curr)
            {
                ans++;
                curr=temp;
            }
        }
        if(curr<n-1) return -1;
        return ans;
    }
}
