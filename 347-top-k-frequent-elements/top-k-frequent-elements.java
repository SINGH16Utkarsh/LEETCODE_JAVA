class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x : nums){
            
            map.put(x, map.getOrDefault(x,0)+1);
        }
        List<int[]> list = new ArrayList<>();
        for(int key : map.keySet()){
            list.add(new int[]{key, map.get(key)});
        }

        Collections.sort(list, (a,b)-> b[1]-a[1]);

        int result[] = new int[k];
        for(int i=0; i<k; i++){
            result[i] = list.get(i)[0];
        }
        return result;
    }

}