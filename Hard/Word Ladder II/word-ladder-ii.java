//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends




//User function Template for Java
class pair
{
    ArrayList<String> l;
    int level;
    pair(ArrayList<String> l,int x)
    {
        this.l=l;
        level=x;
    }
}
class Solution
{
    public void helper(String s,ArrayList<String> curr,ArrayList<String> used,
    HashSet<String> set,Queue<ArrayList<String>> q)
    {
        char ch[]=s.toCharArray();
        int i,j,n=ch.length;
        for(i=0;i<n;i++)
        {
            char temp[]=s.toCharArray();
            for(j=0;j<26;j++)
            {
                temp[i]=(char)(j+'a');
                if(set.contains(new String(temp)))
                {
                    curr.add(new String(temp));
                    q.offer(new ArrayList<>(curr));
                    used.add(new String(temp));
                    curr.remove(curr.size()-1);
                }
            }
        }
    }
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        int level=0;
        ArrayList<ArrayList<String>> list=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        for(String x:wordList)
        set.add(x);
        
        Queue<ArrayList<String>> q=new LinkedList<>();
        ArrayList<String> used=new ArrayList<>();
        ArrayList<String> d=new ArrayList<>();
        d.add(startWord);
        used.add(startWord);
        q.offer(d);
        //used.clear();
        
        while(!q.isEmpty())
        {
            ArrayList<String> top=q.poll();
            String s=top.get(top.size()-1);
            if(top.size()>level)
            {
                level++;
                for(String x:used)
                set.remove(x);
            }
            if (s.equals(targetWord)) {
                // the first sequence where we reached the end.
                if (list.size() == 0) {
                    list.add(top);
                } else if (list.get(0).size() == top.size()) {
                    list.add(top);
                }
            }
           
            helper(top.get(top.size()-1),top,used,set,q);
        }
        return list;
    }
}