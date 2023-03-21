//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
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
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class pair
{
    String str;
    int level;
    pair(String s,int x)
    {
        str=s;
        level=x;
    }
}
class Solution
{
    public void helper(String s,int level,HashSet<String> set,Queue<pair> q)
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
                    q.offer(new pair(new String(temp),level+1));
                    set.remove(new String(temp));
                }
            }
        }
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        int mini=Integer.MAX_VALUE;
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(startWord,1));
        HashSet<String> set=new HashSet<>();
        for(String x:wordList)
        set.add(x);
        set.remove(startWord);
        while(!q.isEmpty())
        {
            pair top=q.poll();
            if(top.str.equals(targetWord))
            {
                return top.level;
            }
            helper(top.str,top.level,set,q);
        }
        return mini==Integer.MAX_VALUE?0:mini;
    }
}