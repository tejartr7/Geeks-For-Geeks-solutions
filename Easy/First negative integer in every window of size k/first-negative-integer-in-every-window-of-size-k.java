//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long a[], int n, int k)
    {
       long ans[]=new long[n-k+1]; 
       int i=0,j=0;
       int index=0;
       Queue<Long> pq=new LinkedList<>();
       while(j<n)
       {
           if(a[j]<0)
           {
               pq.offer(a[j]);
           }
           if(j-i+1==k)
           {
               if(pq.size()==0)
               ans[index++]=0;
               else
               {
                   ans[index++]=pq.peek();
                   if(a[i]==pq.peek())
                   {
                       pq.poll();
                   }
               }
               i++;
           }
           j++;
       }
       return ans;
    }
}