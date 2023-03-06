//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean checkSetBit(int n,int i)
    {
        n=n>>i;
        return n%2==1;
    }
    public static int noConseBits(int n) {
        // code here
        int i;
        int x=n;
        int count=0;
        int arr[]=new int[32];
        Arrays.fill(arr,0);
        int ans=0;
        for(i=0;i<32;i++)
        {
            if(checkSetBit(x,31-i))
            {
                arr[31-i]=1;
                count++;
            }
            else
            count=0;
            if(count==3)
            {
                count=0;
                arr[31-i]=0;
            }
        }
       /* for(i=0;i<32;i++)
        {
            System.out.print(arr[i]+" ");
        }*/
        for(i=0;i<32;i++)
        {
            if(arr[i]==1)
            {
                ans+=Math.pow(2,i);
            }
        }
        return ans;
    }
}
        
