//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSum(String s) {
        // code here
        char ch[]=s.toCharArray();
        int n=s.length();
        int ans=0;
        int i=0,j=n-1;
        while(i<j)
        {
            
            if(ch[i]!='?' && ch[j]=='?')
            {
                ch[j]=ch[i];
            }
            else if(ch[i]=='?' && ch[j]!='?')
            {
                ch[i]=ch[j];
            }
            else if(ch[i]!=ch[j])
            {
                return -1;
            }
            else if(ch[i]=='?' && ch[j]=='?')
            {
                if(i>=1)
                {
                    ch[i]=ch[j]=ch[i-1];
                }
                else
                {
                    char a=(char)('z'+1);
                    char b=(char)('z'+1);
                    int p=i,q=i;
                    for(int k=i;k<=j;k++)
                    {
                        if(ch[k]!='?')
                        {
                            p=k;
                            a=ch[k];
                            break;
                        }
                    }
                    for(int k=j;k>=i;k--)
                    {
                        if(ch[k]!='?')
                        {
                            q=k;
                            b=ch[k];
                            break;
                        }
                    }
                    if(a==(char)('z'+1) && b==(char)('z'+1))
                    return 0;
                    if(p-i<j-q)
                    ch[i]=ch[j]=a;
                    else ch[i]=ch[j]=b;
                }
            }
            i++;
            j--;
        }
       // System.out.println(new String(ch));
        for(i=0;i<n-1;i++)
        ans+=Math.abs(ch[i]-ch[i+1]);
        return ans;
    }
}
