//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class pair
{
    int node;
    int val;
    pair(int a,int b)
    {
        node=a;
        val=b;
    }
}
class Solution {
      int findCity(int n, int m, int[][] edges,int dis)
      {
          //code here
          int[] temp=new int[n];
          int i,j;
          Map<Integer,ArrayList<pair>> map=new HashMap<>();
          for(i=0;i<n;i++)
          {
              map.put(i,new ArrayList<>());
          }
          for(i=0;i<m;i++)
          {
              int x=edges[i][0];
              int y=edges[i][1];
              int z=edges[i][2];
              map.get(x).add(new pair(y,z));
              map.get(y).add(new pair(x,z));
          }
          for(i=0;i<n;i++)
          {
              PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.val-b.val);
              int[] dist=new int[n];
              Arrays.fill(dist,1000_000_000);
              dist[i]=0;
              pq.offer(new pair(i,0));
              while(!pq.isEmpty())
              {
                  pair top=pq.poll();
                  int node=top.node;
                  int val=top.val;
                  if(val>dis)
                  break;
                  for(pair x:map.get(node))
                  {
                      if(x.val+val<dist[x.node])
                      {
                          dist[x.node]=x.val+val;
                          pq.offer(new pair(x.node,dist[x.node]));
                      }
                  }
              }
              int cnt=0;
              for(j=0;j<n;j++)
              {
                  if(dist[j]<=dis)
                  cnt++;
              }
              temp[i]=cnt;
          }
          int mini=Integer.MAX_VALUE;
          int ans=-1;
          for(i=0;i<n;i++)
          {
              if(mini>temp[i])
              {
                  mini=temp[i];
                  ans=i;
              }
              else if(mini==temp[i])
              {
                  ans=Math.max(i,ans);
              }
          }
          return ans;
      }
}
