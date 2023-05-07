//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String stringMirror(String str) {
        // code here
        String ans="z".repeat(100000);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++)
        {
            //StringBuilder sb=new StringBuilder(str.substring(0,i+1));
            sb.append(str.charAt(i));
            String temp=sb.toString();
            temp+=sb.reverse().toString();
            sb=sb.reverse();
            if(ans.compareTo(temp)>0)
            ans=temp;
            if(i>1 && str.charAt(i)>str.charAt(i-1))
            break;
        }
        return ans;
    }
}
        
