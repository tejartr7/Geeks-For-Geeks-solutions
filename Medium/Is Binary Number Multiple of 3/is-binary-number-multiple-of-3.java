//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine().trim());
            while(t-->0)
                {
                    String s = in.readLine().trim();
                    Solution ob = new Solution();
                    out.println(ob.isDivisible(s));
                }
                out.close();
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution {
     int isDivisible(String s) {
        int val = 0;
        int j=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            
            if(ch=='1'){
                if(j%2==0){
                    val+=1;
                }
                else if(j%2!=0){
                    val+=2;
                }
            }
            j++;
        }
        
        if(val%3!=0)return 0;
        
        return 1;
    }
}