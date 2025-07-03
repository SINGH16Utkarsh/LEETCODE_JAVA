class Solution {
    public static void dfs(int grid[][], int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1){
            return;
        }
        grid[i][j]=0;
        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid, i,j-1);
        dfs(grid, i,j+1);
    }
    public int numEnclaves(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(i==0 || j==0 || i==rows-1 || j==cols-1 ){
                    if(grid[i][j] == 1)
                    dfs(grid, i, j);
                }
            }
        }
        int count=0;
          for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
               if( grid[i][j] == 1){
                count++;
               }}}
               return count;
    }
}