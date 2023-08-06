//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends




//User function Template for Java


class Solution
{      
    
      
     ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> permutation(String s)
    {char c[]=s.toCharArray();
   
       getper(c,0,res);
       Collections.sort(res);
       return res;
    }
    void getper(char []c,int index,ArrayList<String> res)
    {
        if(index==c.length)
        {res.add(new String(c));
        return ;
            
        }
        int i;
        for(i=index;i<c.length;i++)
        {
        swap(c,i,index);
        getper(c,index+1,res);
        swap(c,i,index);
        }
    }
    void swap(char []c,int i,int j)
    {
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }
    
   
    
	   
}
