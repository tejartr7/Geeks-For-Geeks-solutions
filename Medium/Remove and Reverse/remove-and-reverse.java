//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
          
            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeReverse(S); 
            System.out.println(ans);
        }
    } 
} 

// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
  
    String removeReverse(String s) 
    { 
        // code here
        Map<Character,Integer> map=new HashMap<>();
        int count[]=new int[1];
        count[0]=0;
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            count[0]++;
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        //System.out.println(count[0]);
        boolean flag=true;
        boolean last=false;
        int rev=0;
        char ch[]=s.toCharArray();
        int i=0,j=s.length()-1;
        while(count[0]>0)
        {
            if(flag)
            {
                int x=map.get(ch[i]);
                if(x>1)
                {
                    rev++;
                    count[0]--;
                    map.put(ch[i],map.get(ch[i])-1);
                    ch[i]='.';
                    i++;
                }
                else
                {
                    i++;
                    continue;
                }
            }
            else
            {
                int x=map.get(ch[j]);
                if(x>1)
                {
                    count[0]--;
                    rev++;
                    map.put(ch[j],map.get(ch[j])-1);
                    ch[j]='.';
                    j--;
                }
                else
                {
                    j--;
                    continue;
                }
            }
            flag=!flag;
            //System.out.println(map);
            //System.out.println(new String(ch));
        }
        s="";
        //System.out.println(new String(ch));
        for(i=0;i<ch.length;i++)
        {
            if(rev%2==0 && ch[i]!='.')
            s+=ch[i];
            else if(rev%2==1 && ch[i]!='.')
            s=ch[i]+s;
        } 
        return s;
    }
} 

//{ Driver Code Starts.

// } Driver Code Ends