//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int[][] dp;
    static int helper(int idx,int w,int[] val,int[] wt)
    {
        int i,j,n=wt.length;
        if(idx>=n)
        return 0;
        if(w==0)
        return 0;
        if(dp[idx][w]!=-1)
        return dp[idx][w];
        int not=helper(idx+1,w,val,wt);
        int take=0;
        if(w>=wt[idx])
        take=val[idx]+helper(idx+1,w-wt[idx],val,wt);
        return dp[idx][w]=Math.max(take,not);
    }
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
        dp=new int[n+1][w+1];
        for(int []x:dp)
        Arrays.fill(x,-1);
        return helper(0,w,val,wt);
    //https://s3.us-west-2.amazonaws.com/practice.gfg.org/p/User/Public/Submission_Files/2023-12-03/cae93c32c9ca1bcf7e319fa188cd7e2a/fileInput.txt?AWSAccessKeyId=ASIAWXS4ESWJ6QMQXJMB&Signature=o9cxxJLHWs076%2F176sa3h0F2c0Y%3D&x-amz-security-token=IQoJb3JpZ2luX2VjENL%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLXdlc3QtMiJHMEUCIA6XVHJ9qxpdpqAMmYdmzHS2dPZFXX7vG3o5l467PHNaAiEAu4tVzsUMRBjUukLd8iT6zfUUFgF7pop%2FIUpUdTrG5dAqhwQIOhAEGgw0NjI5NzU5NjQ1NjMiDH%2B%2BB1Na%2FqzHAyI1ICrkAwsmZh%2BehrqtpxNoEvIoA%2FUQAH8Qi51m%2BWECU4fg07Qz1JkBg2358dsOsRwrXmhPU8bbrZP0swdUoZsEAy5ocem%2F0GO9WlPLs2%2FaoVAAFUCDvwiGdUynaWB0nVTWOunOwHVJ8HzLi8FLpvDM6Uf0y5LAr3jWhVod8J3AlRpHIxWXnws2G1FvHAUn6f7EyPzjzT%2Be2XLXRd24zo3DCw9l1gGM2fmg6pQ5T6AjDDg0r5o61nSHJ7C6ahLZOpLUs340Qscar%2BPJNEcmu4a%2F7iYeGsYt9rVUR8854fuIYUjrs8SEvfAX7Ggp1jDH8q4m5sFkEzAiHGPmWr419ZBWbrAIx2ZWtp4ExTNC%2FgrEiND%2FYsuZtik%2BFRAqidhf0mRr%2FBSQzodP%2BqtuWpl9eRH5NlcssZGxFF04I9gU9s47%2FwoYx0Y6%2BdU2JyrTQErKKKn7sJFf0LVb2h83RmRUQzEfgDiVVfKcvAi8rx9StyRlM%2Fai4YcNlVbEv%2BjL8skFjdasnEuniUhSEM6vdJ6FwP%2FqqsJWsmRtEdSRgctfbVHVC7N2TrpIlYhH8j%2F%2B2oCSPr36U3FFvYcxbMpBdL6%2FpNe0RqBzeWZFqKYeXPZ5%2FeggmgQInQKV%2Fd6t9GfBjF%2FTraupMHeixpvIg%2BEwo6%2BvqwY6pQGOaZwRDwTQxzVkaOWvKnnYO4YTDkp4cFI5RW2Psl9ncJ8rZreIuN5pJjdhY1%2F6dPFYErA622%2B6SbyQoFLDnLY2dqzLqHss%2FYjqXS8GfrSCTfesq06NSV5fjz%2FEt1WDXCInZuZYRp47ZP6YW1jNCMbMthSNVGD5nf1J6mkj5Hx8VFSwuEBN0cbMm5WUbEJ4T78LvKlfQxPS32paaHYCM19dkukMmp0%3D&Expires=1701617070     // your code here 
    } 
}


