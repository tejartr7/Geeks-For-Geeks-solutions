//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String s) 
    { 
        // code here
        int i,n=s.length();
        int a[]=new int[n];
        for(i=0;i<n;i++)
        {
            int x=s.charAt(i)-'a';
            if(x<0)
            a[i]=-1;
            else a[i]=1;
        }
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        map.put(0,1);
        int curr=0;
        for(i=0;i<n;i++)
        {
            curr+=a[i];
            if(map.containsKey(curr))
            {
                count+=map.get(curr);
            }
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return count;
    }
} 
