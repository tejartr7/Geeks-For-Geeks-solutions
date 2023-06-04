//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String S)
    {
        // your code here
        StringBuilder ans=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        char ch[]=S.toCharArray();
        int i,n=S.length();
        for(i=n-1;i>=0;i--)
        {
            if('0'<=ch[i] && ch[i]<='9')
            {
                stack.push(ch[i]);
            }
            else
            {
                while(!stack.isEmpty())
                    ans.append(stack.pop());
                ans.append(ch[i]);
            }
        }
        while(!stack.isEmpty())
                ans.append(stack.pop());
        return ans.toString();
    }
}