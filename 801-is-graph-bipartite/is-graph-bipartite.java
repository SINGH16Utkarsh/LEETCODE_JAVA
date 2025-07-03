class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int current = q.remove();

                    for(int j =0;j<graph[current].length;j++){
                        int next = graph[current][j];

                        if(color[next]==-1){
                            int nextColor = color[current]==0?1:0;
                            color[next]=nextColor;
                            q.add(next);
                        }else if(color[next]==color[current]){
                            return false;
                        }

                    }
                }

            }
        }
        return true;
     } 
    } 
   

