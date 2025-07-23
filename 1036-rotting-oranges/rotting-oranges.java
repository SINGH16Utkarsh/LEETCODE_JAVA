class Solution {

    public static void dfs(int grid[][],int time[][], int i, int j, int currentTime){
        if(i<0 || j<0|| i>=grid.length || j>=grid[0].length || currentTime >= time[i][j]  || grid[i][j]==0){
            return;
        }
        time[i][j]= currentTime;
        dfs(grid,time,i-1,j,currentTime+1);
        dfs(grid,time,i+1,j,currentTime+1);
        dfs(grid,time,i,j-1,currentTime+1);
        dfs(grid,time,i,j+1,currentTime+1);
    }
    public int orangesRotting(int[][] grid) {
      if(grid.length==0 || grid == null){
        return 0;
      }
         int rows = grid.length;
        int cols = grid[0].length;
      int time[][] = new int[rows][cols];
      for(int i=0; i<rows; i++){
        Arrays.fill(time[i], Integer.MAX_VALUE);
      }
      for(int i=0; i<rows; i++){
        for (int j=0; j<cols; j++){
            if(grid[i][j]==2){
                dfs(grid, time, i, j,0);
            }
        }
      }
      int timerequired=0;
      for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            if(grid[i][j]==1){
            if(time[i][j]==Integer.MAX_VALUE){
                return -1; 
            }
            timerequired= Math.max(timerequired , time[i][j]);
        }}
      }
      return timerequired;
}
}