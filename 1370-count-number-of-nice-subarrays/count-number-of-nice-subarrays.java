class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // empty prefix sum
        int sum = 0, result = 0;

        for (int num : nums) {
            // mark 1 for odd, 0 for even
            sum += num % 2;

            // check if there is a prefix sum to form subarray with exactly k odd numbers
            result += prefixCount.getOrDefault(sum - k, 0);

            // record current prefix sum
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}