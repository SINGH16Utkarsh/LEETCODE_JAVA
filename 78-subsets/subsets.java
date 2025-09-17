class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int total = 1 << n;  // 2^n subsets
        
        List<List<Integer>> result = new ArrayList<>(total);
        
        for (int mask = 0; mask < total; mask++) {
            // Instead of starting with empty, estimate subset size quickly
            int size = Integer.bitCount(mask);
            List<Integer> subset = new ArrayList<>(size);
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        
        return result;
    }
}