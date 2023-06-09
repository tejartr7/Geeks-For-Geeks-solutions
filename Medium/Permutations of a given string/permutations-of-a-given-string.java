//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public void swap(int i,int j,char ch[])
    {
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
    public void helper(int ind,List<String> list,char ch[])
    {
        if(ind>=ch.length) 
        {
            String temp=new String(ch);
            if(!list.contains(temp))
            list.add(temp);
            return ;
        }
        for(int i=ind;i<ch.length;i++)
        {
            swap(i,ind,ch);
            helper(ind+1,list,ch);
            swap(i,ind,ch);
            //swap(i,ind,ch);
        }
    }
    public List<String> find_permutation(String s) {
        // Code here
        List<String> list=new ArrayList<>();
        helper(0,list,s.toCharArray());
        Collections.sort(list);
        return list;
    }
}