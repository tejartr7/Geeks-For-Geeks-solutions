//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[])
    {
        // code here
        //Arrays.sort(a);
        int dp[]=new int[n];
        int i,j;
        Arrays.fill(dp,1);
        for(i=1;i<n;i++)
        {
            for(j=i-1;j>=0;j--)
            {
                if(a[j]<a[i])
                dp[i]=Math.max(dp[i],1+dp[j]);
            }
        }
        int maxi=0;
        for(int x:dp)
        maxi=Math.max(maxi,x);
        return maxi;
       // return 5;
    }
} 