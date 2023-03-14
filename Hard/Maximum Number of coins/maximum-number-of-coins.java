//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int maxCoins(int N, ArrayList<Integer> arr) {
	//Write your code here
	// add 1 at the beginning and end of the list
        arr.add(0, 1);
        arr.add(1);
        
        int n = arr.size();
        int[][] dp = new int[n][n];
        
        // l is the length of the subarray
        for (int l = 3; l <= n; l++) {
            // i is the starting index of the subarray
            for (int i = 0; i <= n - l; i++) {
                // j is the ending index of the subarray
                int j = i + l - 1;
                // k is the index of the last balloon to be burst
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr.get(i) * arr.get(k) * arr.get(j));
                }
            }
        }
        
        return dp[0][n-1];
	}

}