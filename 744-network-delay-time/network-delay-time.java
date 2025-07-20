class Solution {
    static class Edge{
        int src, dest, wt;
        public Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    static class Pair  implements Comparable<Pair>{
        int n , time;
        public Pair(int n, int t){
            this.n=n;
            this.time=t;
        }
        @Override
        public int compareTo(Pair p2){
            return this.time-p2.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
       ArrayList<Edge> graph[] = new ArrayList[n+1]; //start from index-1
       for(int i=0; i<=n; i++){
        graph[i]=new ArrayList<>();
       }

       for(int time[] : times){
        int u = time[0];
        int v = time[1];
        int w = time[2];

        graph[u].add(new Edge(u,v,w));
       }

       int dist[] = new int[n+1];

       for(int i=0; i<=n; i++){
        
            dist[i]=Integer.MAX_VALUE;
        
       }
       dist[k]=0;
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       pq.add(new Pair(k,0));

       boolean vis[]= new boolean[n+1];

       while(!pq.isEmpty()){
        Pair curr = pq.remove();
        if(!vis[curr.n]){
            vis[curr.n]=true;
        
        //neighbours
        
             for (Edge e : graph[curr.n]) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
         int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
