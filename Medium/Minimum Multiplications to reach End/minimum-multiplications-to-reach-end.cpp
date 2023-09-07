//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++



class Solution {
  public:
    int minimumMultiplications(vector<int>& arr, int start, int end) {
        if(start==end) return 0;
        int mod = 1e5;
        vector<bool> vis(mod);
        queue<pair<int,int>> q;
        q.push({0,start});
        vis[start]=1;
        while(!q.empty()){
            auto it = q.front();
            int level=it.first;
            int temp=it.second;
            q.pop();
                for(int j=0;j<arr.size();j++){
                    int prod = (temp * arr[j])%mod;
                    if(prod==end) return level+1;
                    if(vis[prod]) continue;
                    q.push({level+1,prod});
                    vis[prod]=1;
                }
            
        }
        
        return -1;
        
    }
};




//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        int start, end;
        cin >> start >> end;
        Solution obj;
        cout << obj.minimumMultiplications(arr, start, end) << endl;
    }
}

// } Driver Code Ends