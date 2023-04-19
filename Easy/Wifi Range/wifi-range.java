//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int n, String s, int x) 
    { 
        // code here
        char ch[]=s.toCharArray();
        int i,j,k;
        for(i=0;i<s.length();i++)
        {
           
           if(ch[i]=='1')
           {
               for(j=i-x;j<=i+x;j++)
               {
                   if(j>=0 && j<n)
                   {
                       if(ch[j]=='0')
                       ch[j]='2';
                   }
               }
           }
           //System.out.println(new String(ch));
        }
        s=new String(ch);
        //System.out.println(s);
        return !s.contains("0");
    }
} 