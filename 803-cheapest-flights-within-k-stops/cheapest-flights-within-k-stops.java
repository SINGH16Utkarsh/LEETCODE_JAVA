class Solution {
    static class Edge{
        int src;
        int dest;
        int price;

        public Edge(int src, int dest, int price){
            this.src = src;
            this.dest = dest;
            this.price = price;
        }
    }

    static class Info implements Comparable<Info>{
        int node;
        int cost;
        int stops;

        public Info(int node, int cost, int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }

        @Override
        public int compareTo(Info i){
            return this.cost - i.cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        //making the graph
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] flight: flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph[from].add(new Edge(from,to,price));
        }
        //initializing data structures for dijkstra
        
        int[] costs = new int[n];
        int[] stops = new int[n];
        PriorityQueue<Info> pq = new PriorityQueue<>();

        Arrays.fill(costs,Integer.MAX_VALUE);
        Arrays.fill(stops,Integer.MAX_VALUE);
        pq.add(new Info(src,0,0));
        costs[src] = 0;
        stops[src] = 0;

        //performing the dijkstra
        while(!pq.isEmpty()){
            Info curr = pq.poll();

            if(curr.node == dst)
                return curr.cost;

            if(curr.stops > k)
                continue;

            for(Edge e: graph[curr.node]){
                int newCost = curr.cost + e.price;
                int newStops = curr.stops + 1;

                //it will traverse through the path if 
                // 1. it is cheaper regardless of the stops
                // 2. it uses fewer stops with same or lower cost
                if(newCost < costs[e.dest] || newStops < stops[e.dest]){
                    costs[e.dest] = newCost;
                    stops[e.dest] = newStops;
                    pq.add(new Info(e.dest,newCost,newStops));
                }
            }
        }

        if(costs[dst] == Integer.MAX_VALUE){
            return -1;
        }else{
            return costs[dst];
        }

    }
}