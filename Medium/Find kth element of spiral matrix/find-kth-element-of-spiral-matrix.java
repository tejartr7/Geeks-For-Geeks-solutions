//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int a[][], int m, int n, int k)
    {
	// Your code here
	    int rmax=m-1,rmin=0;
	    int cmax=n-1,cmin=0;
	    int i=0,j=0;
	    while(rmax>=rmin && cmax>=cmin)
	    {
	        for(int x=cmin;x<=cmax;x++)
	        {
	            k--;
	            if(k==0) return a[rmin][x];
	        }
	        rmin++;
	        for(int x=rmin;x<=rmax;x++)
	        {
	            k--;
	            if(k==0)
	            return a[x][cmax];
	        }
	        cmax--;
	        for(int x=cmax;x>=cmin;x--)
	        {
	            k--;
	            if(k==0)
	            return a[rmax][x];
	        }
	        rmax--;
	        for(int x=rmax;x>=rmin;x--)
	        {
	            k--;
	            if(k==0)
	            return a[x][cmin];
	        }
	        cmin++;
	    }
	    return -1;
    }
}