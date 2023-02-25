//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String s, String t) {
        // code here
        int i = 0, n = t.length();
        int j = 0;
        String ans="";
        while (i < n && j < s.length()) {
          if(t.charAt(i)=='0')
          {
              i++;
              continue;
          }
          else if(s.charAt(j)==t.charAt(i))
          {
              i++;
              j++;
              continue;
          }
          int count=0;
          while(i<n && Character.isDigit(t.charAt(i)))
          {
            count=count*10 + (t.charAt(i)-'0');
            i++;
          }
          j+=count;
          if(count==0) return 0;
        }
        //System.out.println(ans);
        return i==n && j==s.length()?1:0;
    }
}