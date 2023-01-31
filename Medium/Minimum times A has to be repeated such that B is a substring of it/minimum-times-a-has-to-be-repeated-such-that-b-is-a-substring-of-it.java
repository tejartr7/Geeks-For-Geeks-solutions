//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A,B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String a, String b) {
        // code here
        int count=1;
        String x=a;
        while(a.length()<=10000)
        {
            if(a.contains(b))
            return count;
            a+=x;
            count++;
        }
        if(a.contains(b))
        return count;
        //System.out.println(count);
        return -1;
    }
};