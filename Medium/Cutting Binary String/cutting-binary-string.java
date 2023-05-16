//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            
            System.out.println(ob.cuts(s));
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int cuts(String s)
    {
        // code here
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int k = i; k >= 0; k--) {
                if (s.charAt(k) != '0' && isPowerOfFive(s.substring(k, i + 1))) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[k] + 1);
                }
            }
        }

        return dp[n] != n + 1 ? dp[n] : -1;
    }
    private static boolean isPowerOfFive(String str) {
        long num = Long.parseLong(str, 2);
        while (num > 1 && num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}


