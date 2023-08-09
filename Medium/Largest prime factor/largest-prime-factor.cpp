//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std;

// } Driver Code Ends



class Solution{
public: 
    bool valid(long long i)
    {
        if(i<=1)
        return false;
        for(long long x=2;x*x<=i;x++)
        if(i%x==0)
        return false;
        return true;
    }
    long long int largestPrimeFactor(int n){
        // code here
        long long x=n;
        long long i;
        long long maxi=-1;
        for(i=1;i*i<=n;i++)
        {
            if(n%i==0)
            {
                if(valid(n/i))
                maxi=max(n/i,maxi);
                if(valid(i))
                maxi=max(i,maxi);
            }
        }
        return maxi;
    }
};





//{ Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin>>N;
        Solution ob;
        cout << ob.largestPrimeFactor(N) << endl;
    }
    return 0; 
}
// } Driver Code Ends