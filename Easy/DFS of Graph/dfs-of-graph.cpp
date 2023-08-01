//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends





class Solution {
public:
    // Function to return a list containing the DFS traversal of the graph.
    void dfs(vector<int>& res, int v, vector<int> adj[], bool vis[]) {
        if (vis[v])
            return;
        vis[v] = true;
        res.push_back(v);
        for (int x : adj[v]) {
            if (!vis[x])
                dfs(res, x, adj, vis);
        }
    }

    vector<int> dfsOfGraph(int v, vector<int> adj[]) {
        // Code here
        vector<int> res;
        bool vis[v+1];
        for (int i = 0; i <= v; i++) {
            vis[i] = false;
        }
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(res, i, adj, vis);
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
        cin >> V >> E;

        vector<int> adj[V];

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        // string s1;
        // cin>>s1;
        Solution obj;
        vector<int> ans = obj.dfsOfGraph(V, adj);
        for (int i = 0; i < ans.size(); i++) {
            cout << ans[i] << " ";
        }
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends