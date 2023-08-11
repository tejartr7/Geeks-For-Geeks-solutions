//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends



class Solution {
public:
    long long int helper(int idx, int coins[], int sum, long long int dp[1001][1001]) {
        if (idx == 0) {
            if (sum % coins[idx] == 0)
                return dp[idx][sum] = 1LL;
            return dp[idx][sum] = 0LL;
        }
        if (dp[idx][sum] != -1)
            return dp[idx][sum];
        long long int take = 0;
        long long int notTake = helper(idx - 1, coins, sum, dp);
        if (sum >= coins[idx])
            take = helper(idx, coins, sum - coins[idx], dp);
        return dp[idx][sum] = take + notTake;
    }
    
    long long int count(int coins[], int n, int sum) {
        long long int dp[1001][1001];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(n - 1, coins, sum, dp);
    }
};





//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int sum, N;
        cin >> sum >> N;
        int coins[N];
        for (int i = 0; i < N; i++) cin >> coins[i];
        Solution ob;
        cout << ob.count(coins, N, sum) << endl;
    }

    return 0;
}


// } Driver Code Ends