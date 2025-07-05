class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int indegree[] = new int[graph.length];
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<graph.length; i++){
            for(int nbr : graph[i]){
                indegree[i]++;
                adj.get(nbr).add(i);
            }}

            for(int i=0; i<graph.length; i++){
                if(indegree[i]==0){
                    q.add(i);
                }
            }
            while(!q.isEmpty()){

            int curr=q.remove();
            ans.add(curr);

            for(int nbr :adj.get(curr)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        Collections.sort(ans);
        return ans;
        }
    }
