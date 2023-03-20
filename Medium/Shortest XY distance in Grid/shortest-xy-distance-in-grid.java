//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            ArrayList<ArrayList<Character>> grid = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Character> col = new ArrayList<>();
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    col.add(S1[j].charAt(0));
                }
                grid.add(col);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestXYDist(grid, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair
{
    int i,j;
    pair(int i,int j)
    {
        this.i=i;
        this.j=j;
    }
}
class Solution {
    
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int m,
                              int n) {

        //code here
        int mini=Integer.MAX_VALUE;
        ArrayList<pair> x=new ArrayList<>();
        ArrayList<pair> y=new ArrayList<>();
        char ch[][]=new char[m][n];
        int i,j;
        i=0;
        for(ArrayList<Character> r:grid){
        for(j=0;j<n;j++)
        {
            ch[i][j]=r.get(j);
        }
        i++;
        }
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(ch[i][j]=='X')
                {
                     x.add(new pair(i,j));
                }
                else if(ch[i][j]=='Y')
                     y.add(new pair(i,j));
            }
        }
        for(pair a:x){
            for(pair b:y)
            {
                mini=Math.min(mini,Math.abs(a.i-b.i)+Math.abs(a.j-b.j));
            }
        }
        return mini;
    }
};