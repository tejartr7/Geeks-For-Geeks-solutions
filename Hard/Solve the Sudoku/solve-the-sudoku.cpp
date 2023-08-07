//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
// UNASSIGNED is used for empty cells in sudoku grid 
#define UNASSIGNED 0  

// N is used for the size of Sudoku grid.  
// Size will be NxN  
#define N 9  


// } Driver Code Ends




class Solution 
{
    public:
    //Function to find a solved Sudoku. 
    bool SolveSudoku(int grid[N][N])  
    { 
        // Your code here
        int i,j,k;
        for(i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            {
                if(grid[i][j]==0){
                for(k=1;k<=9;k++)
                {
                    if(valid(i,j,grid,k))
                    {
                        grid[i][j]=k;
                        if(SolveSudoku(grid))
                        return true;
                        else grid[i][j]=0;
                    }
                }
                return false;
                }
            }
        }
        return true;
    }
    bool valid(int i,int j,int grid[N][N],int k)
    {
        for(int x=0;x<9;x++)
        {
            if(grid[i][x]==k || grid[x][j]==k)
            return false;
            if(grid[3*(i/3)+x/3][3*(j/3)+x%3]==k)
            return false;
        }
        return true;
    }
    
    //Function to print grids of the Sudoku.
    void printGrid (int grid[N][N]) 
    {
        // Your code here 
          if(SolveSudoku(grid) == true){
           for(int i = 0 ; i<N;i++){
               for(int j = 0 ; j<N;j++) cout<<grid[i][j]<<" ";
           }
       }
    }
};



//{ Driver Code Starts.

int main() {
	int t;
	cin>>t;
	while(t--)
	{
		int grid[N][N];
		
		for(int i=0;i<9;i++)
		    for(int j=0;j<9;j++)
		        cin>>grid[i][j];
		        
		Solution ob;
		
		if (ob.SolveSudoku(grid) == true)  
            ob.printGrid(grid);  
        else
            cout << "No solution exists";  
        
        cout<<endl;
	}
	
	return 0;
}
// } Driver Code Ends