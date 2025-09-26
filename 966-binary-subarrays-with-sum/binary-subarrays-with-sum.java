class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // empty prefix sum
        int sum = 0, result = 0;

        for (int num : nums) {
            sum += num;

            // check if there is a prefix that would make a subarray sum = goal
            result += prefixCount.getOrDefault(sum - goal, 0);

            // record current prefix sum
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }

        return result; 
    }
}