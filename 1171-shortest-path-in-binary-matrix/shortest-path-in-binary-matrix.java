class Solution {
    class Pair {
        int u, v;
        Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
     int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
     int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;

        //return if start is blocked
        if(grid[0][0]==1||grid[r-1][c-1]==1){
            return -1;
        }
        int dist[][]= new int [r][c];
        for(int x []:dist){
            Arrays.fill(x,(int)1e9);
        }

        dist[0][0]=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));

        while(!q.isEmpty()){
            Pair p=q.poll();
            int u=p.u;
            int v=p.v;

            for(int i=0; i<8; i++) {
                int nr = u + dx[i];
                int nc = v + dy[i];

      if(!invalid(nr,nc,r,c) && grid[nr][nc]==0 && dist[u][v]+1<dist[nr][nc]){
               dist[nr][nc] = dist[u][v] + 1;
                    q.add(new Pair(nr, nc));
            }   }     }
              
    return dist[r - 1][c - 1] != (int) 1e9 ? dist[r - 1][c - 1] + 1 : -1;
       
    }
     boolean invalid(int i, int j, int r, int c) {
        return i < 0 || i >= r || j < 0 || j >= c;
}}