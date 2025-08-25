class Solution {
    public List<Integer> majorityElement(int[] nums) {
      //  int count=0;
        int n= nums.length;
        List<Integer> ans = new ArrayList<>();
       
       HashMap<Integer,Integer> map = new HashMap<>();

       for(int i=0; i<nums.length; i++){
        map.put(nums[i], map.getOrDefault(nums[i],0)+1);
       }

       
       for(Integer key : map.keySet()){
        if(map.get(key)>nums.length/3){
            ans.add(key);
        }
       }
       return ans;
    }
}

