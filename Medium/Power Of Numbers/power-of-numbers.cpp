//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution{
    public:
    //You need to complete this fucntion
    
    long long power(int n,int r)
    {
       //Your code here
        long long mod=1000000007;
        if(r==0) return 1;
        long long x=1;
        long long t=(long)n;
        while(r>0)
        {
            if(r%2==1)
            x=(x%mod*t%mod)%mod;
            t=(t%mod*t%mod)%mod;
            r/=2;
        }
        return x;
    }

};

//{ Driver Code Starts.

// compute reverse of a number 
long long rev(long long n)
{
    long long rev_num = 0;
     while(n > 0) 
      { 
        rev_num = rev_num*10 + n%10; 
        n = n/10; 
      } 
      return rev_num;
}




int main()
{
    int T;
    cin>>T;//testcases
    
    while(T--)
    {
        long long N;
        cin>>N;//input N
        
        long long R = 0; 
        
        // reverse the given number n
        R = rev(N);
        Solution ob;
        //power of the number to it's reverse
        long long ans =ob.power(N,R);
        cout << ans<<endl;
    }
}
// } Driver Code Ends