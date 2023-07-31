//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends



class Solution {
public:
    // Function to return Breadth First Traversal of the given graph.
    vector<int> bfsOfGraph(int n, vector<int> adj[]) {
        queue<int> q;
        q.push(0);
        bool vis[n + 1];
        for (int i = 0; i <= n; i++)
            vis[i] = false;
        vector<int> res;

        while (!q.empty()) {
            int x = q.front();
            q.pop();
            if (vis[x]) // Check if the node has already been visited
                continue;
            vis[x] = true;
            res.push_back(x);
            
            for (int y : adj[x]) {
                if (!vis[y]) {
                    q.push(y);
                }
            }
        }

        return res;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int V, E;
        cin >> V >>

            E;

        vector<int> adj[V];

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            // 		adj[v].push_back(u);
        }
        // string s1;
        // cin>>s1;
        Solution obj;
        vector<int> ans = obj.bfsOfGraph(V, adj);
        for (int i = 0; i < ans.size(); i++) {
            cout << ans[i] << " ";
        }
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends