//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            String S;
            S = br.readLine();
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.getMinimumDays(N, S, P);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int getMinimumDays(int n, String s, int[] p) {
        // code here
        int count=0;
        int i=0;
        int ans=0;
        for(i=0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            count++;
        }
        if(count==0) return 0;
        char ch[]=s.toCharArray();
        for(i=0;i<n;i++)
        {   ans++;
            if(ch[p[i]]!='?')
            {
                if(p[i]>0 && ch[p[i]]==ch[p[i]-1])
                {
                    count--;
                }
                if(count==0) return ans;
                if(p[i]<n-1 && ch[p[i]]==ch[p[i]+1])
                {
                    count--;
                }
                if(count==0) return ans;
                ch[p[i]]='?';
            }
        }
        return ans;
    }
}
        
