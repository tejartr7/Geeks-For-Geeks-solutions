//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean compare(int a[],int b[])
    {
        for(int i=0;i<26;i++)
        {
            if(a[i]>b[i]) return false;
        }
        return true;
    }
    int search(String pat, String txt) {
        // code here
        //Queue<Character> q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        int i=0,j=0,n=pat.length(),l=txt.length();
        int count=0;
        int arr[]=new int[26];
        int brr[]=new int[26];
        for(int k=0;k<pat.length();k++)
        {
            arr[pat.charAt(k)-'a']++;
        }
        while(j<txt.length())
        {
            //System.out.println(sb);
            //sb.append(txt.charAt(j));
            brr[txt.charAt(j)-'a']++;
            if(j-i+1==n)
            {
                if(compare(arr,brr))
                count++;
                brr[txt.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return count;
    }
}