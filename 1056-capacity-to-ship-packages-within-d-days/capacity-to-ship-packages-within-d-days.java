class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i: weights) {
            high += i;
            low = Math.max(low, i);
        }
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (isPossible(weights,mid,days)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    private boolean isPossible(int[] weights, int capacity, int days) {
        int daysReq = 1;
        int load = 0;
        for (int i: weights) {
            if (load + i > capacity) {
                daysReq++;
                load = i;
            }
            else load += i;
        }
        return daysReq <= days;
    }
}