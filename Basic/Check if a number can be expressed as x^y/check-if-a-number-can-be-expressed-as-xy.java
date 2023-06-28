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
            System.out.println(ob.checkPower(N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int checkPower(int n){
        // code here\
        if(n==1) return 1;
        int x=2,y=2;
        for(x=2;x*x<=n;x++)
        {
            y=2;
            while((int)Math.pow(x,y)<=n)
            {
                if((int)Math.pow(x,y)==n) return 1;
                y++;
            }
        }
        return 0;
    }
}