//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,(a,b)->b.profit-a.profit);
        int maxi=0;
        for(Job x:arr)
        {
            maxi=Math.max(maxi,x.deadline);
        }
        int ans=0;
        int count=0;
        boolean visited[]=new boolean[maxi];
        for(Job x:arr)
        {
            int t=x.deadline;
            t--;
            for(int i=t;i>=0;i--)
            {
                if(!visited[i])
                {
                    ans+=x.profit;
                    count++;
                    visited[i]=true;
                    break;
                }
            }
        }
        int res[]=new int[2];
        res[0]=count;
        res[1]=ans;
        return res;
    }
}