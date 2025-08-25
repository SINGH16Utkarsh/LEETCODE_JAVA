class Solution {
    public List<Integer> majorityElement(int[] nums) {
      //  int count=0;
        int n= nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int count =1;
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]==nums[j]){
                    count++;
                } }
                if(count > (n/3) && !ans.contains(nums[i])){
                 ans.add(nums[i]);

                
        
            }
        }
         return ans;
       
    }
}

