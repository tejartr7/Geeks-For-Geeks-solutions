//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
  
            String x = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.xmod11(x)); 

            t--;
        }
    } 
} 



// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int xmod11(String x)
	{    
	    int val1=0;
	    int val2=0;
	    for(int i=0;i<x.length();i++)
	    {
	        if(i%2==0) val1+=(int)(x.charAt(i)-'0');
	        else val2+=(int)(x.charAt(i)-'0');
	    }
	    return (val2-val1)%11>=0?(val2-val1)%11:(val2-val1)%11+11;
	}
} 

