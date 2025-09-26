class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
   return atMost(nums, k) - atMost(nums, k - 1);
    }

    // helper: number of subarrays with at most K odd numbers
    private int atMost(int[] nums, int k) {
        int left = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) k--; // odd number consumes one flip

            while (k < 0) { // shrink window if too many odds
                if (nums[left] % 2 == 1) k++;
                left++;
            }

            // all subarrays ending at right with at most k odds
            count += right - left + 1;
        }
        return count;
    }
}