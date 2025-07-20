class Solution {
  
    public int minimumEffortPath(int[][] heights) {
        int r=heights.length;
        int c = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
    pq.add(new int[]{0,0,0});
        
        int dist[][] = new int[r][c];
        for(int x[]:dist){
            Arrays.fill(x, (int) 1e9);
        }
        dist[0][0] = 0;
     int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
   
    while(!pq.isEmpty()){
        int[] curr = pq.remove();
        int effort = curr[0], x=curr[1] , y=curr[2];
        if(effort > dist[x][y])  continue;
    

    if(x==r-1 && y==c-1)   return effort;

for(int[] dir : directions){
    int nx = x +dir[0], ny = y + dir[1];

if(nx >= 0 && ny >=0 && nx<r && ny<c ){
  int new_effort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
    if(new_effort < dist[nx][ny]){
        dist[nx][ny] = new_effort;
        pq.add(new int[]{new_effort, nx, ny});
    }
}}}
return -1;
}}

