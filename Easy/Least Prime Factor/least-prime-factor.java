//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.leastPrimeFactor(n);
            for(int i = 1; i <=n; i++)
            {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
 
        // Check if n=2 or n=3
        if (n == 2 || n == 3)
            return true;
 
        // Check whether n is divisible by 2 or 3
        if (n % 2 == 0 || n % 3 == 0)
            return false;
 
        // Check from 5 to square root of n
        // Iterate i by (i+6)
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
 
        return true;
    }
    public int helper(int n)
    {
        int i;
        for(i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                if(isPrime(i)) return i;
            }
        }
        return -1;
    }
    public int[] leastPrimeFactor(int n)
    {
        // code here
        int ans[]=new int[n+1];
        ans[0]=0;
        ans[1]=1;
        int i;
        for(i=2;i<=n;i++)
        {
            if(i<4)
            {
                ans[i]=i;
            }
            else if(isPrime(i))
            ans[i]=i;
            else
                ans[i]=helper(i);
        }
        return ans;
    }
}