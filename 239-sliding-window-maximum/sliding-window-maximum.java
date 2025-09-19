class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // store indices

        for (int i = 0; i < n; i++) {
            // 1. Remove indices out of current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Maintain decreasing order in deque
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // 3. Add current index
            dq.offerLast(i);

            // 4. Window ready → add max (front of deque) to result
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}