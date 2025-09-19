class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
          int n = nums.length;
        int[] res = new int[n - k + 1];
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]   // max-heap by value
        );

        for (int i = 0; i < n; i++) {
            // Add current number with its index
            maxHeap.offer(new int[]{nums[i], i});

            // Remove numbers out of the current window
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            // Save result when first window is ready
            if (i >= k - 1) {
                res[i - k + 1] = maxHeap.peek()[0];
            }
        }
        return res;
    }
}