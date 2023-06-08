//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution
{
public:
string kthPermutation(int n, int k)
    {
       vector<int> v;
       for(int i=1;i<=n;i++) v.push_back(i);
       for(int i=1;i<k;i++){
           next_permutation(v.begin(),v.end());
       }
      string s;
      for(auto i:v){
          s+=i+'0';
      }
      return s;
    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n, k;
        cin >> n >> k;
        Solution ob;
        string ans = ob.kthPermutation(n, k);
        cout << ans;
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends