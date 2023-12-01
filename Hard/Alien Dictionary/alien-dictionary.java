//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    public String findOrder2(int n, char[][] pre) {
        List<List<Character>> list = new ArrayList<>();
        List<Character> topo = new ArrayList<>();
        int[] indegree = new int[n];
        Queue<Character> q = new LinkedList<>();

        if (n == 1 && pre.length == 0) {
            return " "; // Return a string containing a single space
        }

        for (int i = 0; i < n; i++) {
            list.add(i, new ArrayList<>());
        }

        for (int i = 0; i < pre.length; i++) {
            list.get(pre[i][1] - 'a').add(pre[i][0]); 
            indegree[pre[i][0] - 'a']++;
        }

        char[] ans = new char[n];
        int k = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add((char) (i + 'a'));
                ans[k++] = (char) (i + 'a');
            }
        }

        while (!q.isEmpty()) {
            int top = q.poll() - 'a';

            for (char x : list.get(top)) {
                indegree[x - 'a']--;

                if (indegree[x - 'a'] == 0) {
                    q.offer(x);
                    ans[k++] = x;
                }
            }
        }
        //System.out.println(ans);
        return k == n ? new String(ans) : "";
    }
   public String findOrder(String[] dict, int n, int k) {
    List<List<Character>> list = new ArrayList<>();

    for (int i = 0; i < dict.length - 1; i++) {
        String x = dict[i];
        String y = dict[i + 1];
        int minLength = Math.min(x.length(), y.length());

        for (int p = 0; p < minLength; p++) {
            if (x.charAt(p) != y.charAt(p)) {
                List<Character> temp = new ArrayList<>();
                temp.add(y.charAt(p));
                temp.add(x.charAt(p));
                list.add(new ArrayList<>(temp)); // Swap x and y in temp
                break;
            }
        }
    }

    char[][] pairs = new char[list.size()][2];

    for (int i = 0; i < list.size(); i++) {
        pairs[i][0] = list.get(i).get(0);
        pairs[i][1] = list.get(i).get(1);
    }
    int i;
    String x = findOrder2(k, pairs);
    return x;
}
}
