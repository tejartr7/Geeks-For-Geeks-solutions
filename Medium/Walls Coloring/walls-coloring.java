//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] colors, int n){
        //Write your code here
        int x=colors[0][0];
        int y=colors[0][1];
        int z=colors[0][2];
        for(int i=1;i<n;i++)
        {
            int p=x,q=y,r=z;
            x=colors[i][0]+Math.min(r,q);
            y=colors[i][1]+Math.min(p,r);
            z=colors[i][2]+Math.min(p,q);
        }
        return Math.min(x,Math.min(y,z));
    }
}