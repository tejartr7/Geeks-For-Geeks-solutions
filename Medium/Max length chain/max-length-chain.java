//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

class Chainlength
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
               arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            GfG g = new GfG();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}

// } Driver Code Ends


/*
class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}
*/

class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
       // your code here
       Arrays.sort(arr,(Pair a,Pair b)->a.y-b.y);
       int cnt=1;
       int first=arr[0].y;
       for(int i=1;i<n;i++)
       {
          if(first<arr[i].x)
          {
              cnt++;
              first=arr[i].y;
          }
       }
       return cnt;
    }
}

