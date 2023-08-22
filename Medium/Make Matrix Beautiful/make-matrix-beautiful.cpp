//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution
{
    public:
    //Function to find minimum number of operations that are required 
    //to make the matrix beautiful.
    int findMinOpeartion(vector<vector<int> > arr, int n)
    {
        int max_sum =0, ans =0;
        
        for(int i=0; i<n; i++) {
            int sum_row = 0;
            int sum_col = 0;
            
            for(int j=0; j<n; j++) {
                sum_row += arr[i][j];
                sum_col += arr[j][i];
            }
            
            max_sum = max({max_sum, sum_row, sum_col});
        }
        
        for (int i=0; i<n; i++) {
            int sum = 0;
            
            for(int j=0; j<n; j++) {
                sum += arr[i][j];
            }
            
            
            ans += (max_sum - sum);
        }
        
        return ans;
    } 
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        vector<vector<int> > matrix (n,vector<int>(n));
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                cin>>matrix[i][j];
        Solution ob;
        cout << ob.findMinOpeartion(matrix, n) << endl;
    }
    return 0;
}


// } Driver Code Ends