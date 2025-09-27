class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
         return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, res = 0;

        for (int right = 0; right < nums.length; right++) {
            int c = nums[right];
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            while (freq.size() > k) {
                int leftNum = nums[left];
                freq.put(leftNum, freq.get(leftNum) - 1);
                if (freq.get(leftNum) == 0) {
                    freq.remove(leftNum);
                }
                left++;
            }

            // all subarrays ending at right and starting from [left..right]
            res += right - left + 1;
        }

        return res;
    }
}